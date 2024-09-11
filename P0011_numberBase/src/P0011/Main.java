
package P0011;

/**
 *
 * @author HP
 */
public class Main {
    public static void main(String[] args) {
        solveData sd = new solveData();
        Validation val = new Validation();
        while(true) {
            int firstChoice = sd.menu();
            switch (firstChoice) {
                case 1:
                    String bin = val.checkBinary("Enter Binary: ");
                    sd.convertBin(bin);
                    break;
                case 2:
                    String dec = val.checkDecimal("Enter Decimal: ");
                    sd.convertDec(dec);
                    break;
                case 3:
                    String hex = val.checkHexaDecimal("Enter HexaDecimal: ");
                    sd.convertHex(hex);
                    break;
                case 4:
                    return;
            }
        }
    }
}
