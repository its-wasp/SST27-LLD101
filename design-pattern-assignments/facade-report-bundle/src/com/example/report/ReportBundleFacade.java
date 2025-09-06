package com.example.report;

import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;

public class ReportBundleFacade {
    private final JsonWriter writer;
    private final Zipper zipper;
    private final AuditLog auditLog;

    public ReportBundleFacade(JsonWriter writer, Zipper zipper, AuditLog auditLog) {
        this.auditLog = Objects.requireNonNull(auditLog, "auditLog");
        this.writer = Objects.requireNonNull(writer, "writer");
        this.zipper = Objects.requireNonNull(zipper,"zipper");
    }

    public Path export(Map<String, Object> data, Path outDir, String baseName) {
        Objects.requireNonNull(data, "data");
        Objects.requireNonNull(outDir, "outDir");
        Objects.requireNonNull(baseName, "baseName");
        Path jsonPath = writer.write(data, outDir, baseName);
        Path zipPath = zipper.zip(jsonPath, outDir.resolve(baseName + ".zip"));
        auditLog.log("Exported bundle: " + zipPath);
        return zipPath;
    }
}
