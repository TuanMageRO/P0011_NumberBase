
package P0011;

import java.util.Scanner;

public class Validation {
    private final Scanner sc = new Scanner(System.in);
    private final String binaryFormat = "[0-1]*";
    private final String decimalFormat = "[0-9]*";
    private final String hexaDecimalFormat = "[0-9A-F]*";
    
    public int checkInteger(String mess, int min, int max) {
        int n;
        String err = "Only permits integer in range " + min + " to " + max;
        while(true) {
            try{
                System.out.println(mess);
                n = Integer.parseInt(sc.nextLine());
                if(n < min || n > max) {
                    System.err.println(err);
                    continue;
                }
                return n;
            }
            catch (NumberFormatException e) {
                System.err.println(err);
            }
        }
    }
    
    public String checkBinary(String mess) {
        String bin;
        while(true) {
            System.out.println(mess);
            bin = sc.nextLine().trim();
            if(bin.matches(binaryFormat)) {
                return bin;
            }
            else {
                System.err.println("Please enter Binary format correctly.");
            }
        }
    }
    
    public String checkDecimal(String mess) {
        String dec;
        while(true) {
            System.out.println(mess);
            dec = sc.nextLine().trim();
            if(dec.matches(decimalFormat)) {
                return dec;
            }
            else {
                System.err.println("Please enter Decimal format correctly.");
            }
        }
    }
    
    public String checkHexaDecimal(String mess) {
        String hex;
        while(true) {
            System.out.println(mess);
            hex = sc.nextLine();
            if(hex.matches(hexaDecimalFormat)) {
                return hex;
            }
            else {
                System.err.println("Please enter HexaDecimal format correctly.");
            }
        }
    }
}
