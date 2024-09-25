
package Controller;

import java.util.Scanner;
import View.view;
import Model.model;

public class control {

    private final Scanner sc = new Scanner(System.in);
    private final model mod = new model();
    private final view v = new view();
    private final String bin = "Binary";
    private final String dec = "Decimal";
    private final String hex = "HexaDecimal";
    
    public int checkInteger(String mess, int min, int max) {
        while(true) {
            System.out.println(mess);
            String input = sc.nextLine().trim();
            if(input.isEmpty()) {
            System.err.println("Input can not be empty.");          
            }
            else{
                try{
                    int n = Integer.parseInt(input);
                    if(n > max || min > n) {
                        System.err.println("Only permits Integer in range " + min + " to " + max);
                        continue;
                    }
                    return n;
                }
                catch(NumberFormatException e) {
                    System.err.println("Invalid Input Format. Only Intger number (digits) is permitted.");
                }
            }
        }
    }
    
    public String checkNumberBase(String mess, int base) {
        String input;
        while(true) {
            System.out.println(mess);
            input = sc.nextLine().trim().toUpperCase();
            if(input.isEmpty()) {
                System.err.println("Input can not be empty");
            }
            else{
                if(input.length() > 15) {
                System.err.println("Number is out of range, only permit 15 characters number.");
                }
                else{
                    if(numberBaseFormat(input, base)) {
                    return input;
                    }
                    else System.err.println("Invalid Input Format of Base " + base);
                }
            }
        }
    }
    
    private boolean numberBaseFormat(String in, int base) {
        String baseFormat = "0123456789ABCDEF".substring(0, base);
        for(char c : in.toCharArray()) {
            if(baseFormat.indexOf(c) == -1)
                return false;
        }
        return true;
    }
    
    private void converBin() {
        v.option(bin, dec, hex);
        int n = checkInteger("Enter your choice: ", 1, 3);
        if(n == 3) {
            System.out.println("Return to Main Menu...");
            return;
        }
        String s = checkNumberBase("Enter your Binary: ", 2);
        switch(n) {
            case 1 -> mod.converter(s, 2, 10);
            case 2 -> mod.converter(s, 2, 16);
        }
    }
    
    private void convertDec() {
        v.option(dec, bin, hex);
        int n = checkInteger("Enter your choice: ", 1, 3);
        if(n == 3) {
            System.out.println("Return to Main Menu...");
            return;
        }
        String s = checkNumberBase("Enter your Decimal: ", 10);
        switch(n) {
            case 1 -> mod.converter(s, 10, 2);
            case 2 -> mod.converter(s, 10, 16);
        }
    }
    
    private void convertHex() {
        v.option(hex, bin, dec);
        int n = checkInteger("Enter your choice: ", 1, 3);
        if(n == 3) {
            System.out.println("Return to Main Menu...");
            return;
        }
        String s = checkNumberBase("Enter your HexaDecimal: ", 16);
        switch(n) {
            case 1 -> mod.converter(s, 16, 2);
            case 2 -> mod.converter(s, 16, 10);           
        }
    }
    
    public void display() {
        while(true) {
            v.menu();
            int n = checkInteger("Enter your choice: ", 1, 4);
            switch(n) {
                case 1 -> converBin();
                
                case 2 -> convertDec();
                
                case 3 -> convertHex();
                
                case 4 -> {
                    System.out.println("Program Terminated.");
                    return;
                }               
            }
        }
    }
}
