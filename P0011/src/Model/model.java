
package Model;

public class model {
    public void converter(String in, int base1, int base2) {
        String decimal;
        if(base1 != 10){
            decimal = convertToDec(in, base1);
        }
        else decimal = in;
        
        if(base2 == 10) {
            System.out.println("Result = " + decimal + "(" + base2 + ")");
        }
        else {
            String result = convertFromDec(decimal, base2);
            System.out.println("Result = " + result + "(" + base2 + ")");
        }
    }
    
    private String convertToDec(String in, int base1) {
        int power = in.length()-1;
        long decimal = 0;
        String step = "";
        
        System.out.println("Convert from base " + base1 + "to Decimal: ");
        for(int i = 0; i < in.length(); ++i) {
            char c = in.charAt(i);
            step += Character.digit(c, base1) + "*" + base1 + "^" + power ;
            decimal += Character.digit(c, base1) * (long)Math.pow(base1, power);
            if(i < in.length()-1) step  += " + ";
            power--;
        }
        System.out.println(in + "(" + base1 + "}" + " = " + step);
        System.out.println("Result (Decimal) = " + decimal);
        return Long.toString(decimal);
      }
    
    private String convertFromDec (String in, int base2) {
        long dec = Long.parseLong(in);
        String step = "";
        String result = "";
        long remainder;
        
        System.out.println("Convert from Decimal to " + base2 + ": ");
        while(dec > 0) {
            remainder = dec%base2;
            step += dec + "/" + base2 + " = " + (int)dec/base2 + ", Remainder = " + remainder + "\n";
            dec /= base2;
            result = Long.toString(remainder, base2) + result;
        }
        System.out.println(in + "(10) = " + step);
        System.out.println("Result base " + base2 + " = " + result);
        return result;
    }
}
