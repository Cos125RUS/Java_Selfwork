/******************************************************************************
 *  Compilation:  javac Hex2Decimal.java
 *  Execution:    java Hex2Decimal x
 *
 *  Functions to convert x from hex to decimal and back.
 *
 *  % java Hex2Decimal 1F
 *  31
 *
 *  % java Hex2Decimal FF
 *  255
 *
 *  % java Hex2Decimal DEAD
 *  57005
 *
 *  Alternate solution:  Integer.parseInt(s, 16)
 *  This is more robust and works with negative integers.
 *
 ******************************************************************************/

public class Hex2Decimal {

    public static int hex2Decimal(String s) {
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }


    // precondition:  d is a nonnegative integer
    public static String decimal2Hex(int d) {
        String digits = "0123456789ABCDEF";
        if (d == 0) return "0";
        String hex = "";
        while (d > 0) {
            int digit = d % 16;                // rightmost digit
            hex = digits.charAt(digit) + hex;  // string concatenation
            d = d / 16;
        }
        return hex;
    }

    public static void main(String[] args) {
        int decimal = hex2Decimal(args[0]);
        StdOut.println(decimal);

        String hex = decimal2Hex(decimal);
        StdOut.println(hex);
    }
}
