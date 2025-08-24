public class AdvancedPrinter implements Printer, Fax, Scanner {

    public void print(String text){
        System.out.println("Advanced printing: " + text);
    }

    public void scan(String dstPath){
        System.out.println("Scanning: " + dstPath);
    }

    public void fax(String number){
        System.out.println("Faxing to: " + number);
    }
}
