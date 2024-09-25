
package View;

public class view {
    public void menu() {
        System.out.println("=====Number Base Converter=====");
        System.out.println("1. Convert From Binary");
        System.out.println("2. Convert From Decimal");
        System.out.println("3. Convert From HexaDecimal");
        System.out.println("4. Exit");
    }
    
    public void option( String base1, String base2, String base3) {
        System.out.println("1. Convert from base " + base1 + " to " + base2);
        System.out.println("2. Convert from base " + base1 + " to " + base3);
        System.out.println("3. Exit");
    }
}
