/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package P0011;

public class solveData {
    private final Validation valid = new Validation();
    
    public final char[] hexFormat = {
        '0', '1', '2', '3', '4', '5', '6', '7',
        '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
    };
    
    public int menu() {
        System.out.println("1. Convert from Binary.");
        System.out.println("2. Convert from Decimal.");
        System.out.println("3. Convert from HexaDecimal.");
        System.out.println("4. Exit.");
        int choice = valid.checkInteger("Enter your choice: ", 1, 4);
        return choice;
    }
    
    public int option(String base1, String base2, String base3) {
        System.out.println("1. Convert " + base1 + " to " + base2 + ".");
        System.out.println("2. Convert " + base1 + " to " + base3 + ".");
        int choice = valid.checkInteger("Enter your choice: ", 1, 2);
        return choice;
    }
    
    public void convertBin (String bin) {
        int choice = option("Binary", "Decimal", "HexaDecimal");
        switch(choice) {
            case 1:
                System.out.println("Decimal: " + binToDec(bin));
                break;
            case 2:
                System.out.println("HexaDecimal: " + binToHex(bin));
                break;
        }
    }
    
    public void convertDec (String dec) {
        int choice = option("Decimal","Binary", "HexaDecimal");
        switch(choice) {
            case 1:
                System.out.println("Binary : " + decToBin(dec));
                break;
            case 2:
                System.out.println("HexaDecimal: " + decToHex(dec));
                break;
        }
    }
    
     public void convertHex (String hex) {
        int choice = option("HexaDecimal", "Binary", "Decimal");
        switch(choice) {
            case 1:
                System.out.println("Binary: " + hexToBin(hex));
                break;
            case 2:
                System.out.println("Decimal: " + hexToDec(hex));
                break;
        }
    }
     
     public String binToDec(String bin) {
         int dec = Integer.parseInt(bin, 2);
         return Integer.toString(dec);
     }
     
     public String binToHex (String bin) {
         String dec = binToDec(bin);
         String hex = decToHex(dec);
         return hex;
     }
     
     public String decToBin (String dec) {
         String bin = Integer.toBinaryString(Integer.parseInt(dec));
         return bin;
     }
     
     public String decToHex (String dec) {
         String hex = "";
         int decimal = Integer.parseInt(dec);
         while(decimal != 0) {
             hex = hexFormat[decimal%16] + hex;
             decimal /= 16;
         }
         return hex;
     }
     
     public String hexToDec (String hex) {
         int dec = Integer.parseInt(hex, 16);
         return Integer.toString(dec);
     }
     
     public String hexToBin (String hex) {
         String dec = hexToDec(hex);
         String bin = decToBin(dec);
         return bin;
     }
}
