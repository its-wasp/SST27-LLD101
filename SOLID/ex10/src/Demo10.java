public class Demo10 {
    public static void main(String[] args) {
        ReportService reportService = new ReportService(new ConsoleLogger());
        reportService.generate();
    }
}
