public class Demo07 {
    public static void main(String[] args) {
        BasicPrinter basicPrinter = new BasicPrinter();
        AdvancedPrinter advancedPrinter = new AdvancedPrinter();
        basicPrinter.print("Hello");
        advancedPrinter.print("Hello");
//        basicPrinter.scan("/tmp/out"); // compile-time error
//        basicPrinter.fax("12345"); // compile-time error
        advancedPrinter.scan("/tmp/out");
        advancedPrinter.fax("12345");

    }
}
