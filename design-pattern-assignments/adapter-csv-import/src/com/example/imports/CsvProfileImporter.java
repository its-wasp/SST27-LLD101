package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter{
    private final NaiveCsvReader csvReader;
    private final ProfileService service;

    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService service) {
        this.csvReader = Objects.requireNonNull(csvReader, "csvReader");
        this.service = Objects.requireNonNull(service, "service");
    }

    @Override
    public int importFrom(Path csvFile) {
        List<String[]> rows = csvReader.read(csvFile);
        int count = 0;
        int rowNum = 1;
        for (String[] cols : rows) {
            // skip header
            if (rowNum == 1 && cols.length > 1 && "id".equalsIgnoreCase(cols[0]) && "email".equalsIgnoreCase(cols[1])) {
                rowNum++;
                continue;
            }
            if (cols.length < 3) {
                System.out.println("Row " + rowNum + ": not enough columns!");
                rowNum++;
                continue;
            }
            String id = cols[0].trim();
            String email = cols[1].trim();
            String display = cols[2].trim();
            if (id.isEmpty() || email.isEmpty()) {
                System.out.println("Row " + rowNum + ": Missing id or email");
                rowNum++;
                continue;
            }
            if (!email.contains("@")) {
                System.out.println("Row " + rowNum + ": Invalid email '" + email + "skipping!");
                rowNum++;
                continue;
            }
            try {
                service.createProfile(id, email, display);
                count++;
            } catch (Exception e) {
                System.out.println("Row " + rowNum + ": Exception: " + e.getMessage() + " — skipped");
            }
            rowNum++;
        }
        return count;
    }
}
