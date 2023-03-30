/******************************************************************************
 *  Compilation:  javac VIN.java
 *  Execution:    java VIN s
 *
 *  Determines if a VIN number is valid by computing its check digit.
 *  Do aggressive error checking.
 *
 *  % java VIN 1B4YEM9P4KP186543
 *  Invalid
 *
 *  % java VIN 1FA-CP45E-X-LF192944
 *  Valid
 *
 *  % java VIN 1FA-CP45E-6-LF192944
 *  Invalid
 *
 *  % java VIN QFA-CP45E-X-LF192944
 *  Exception in thread "main" java.lang.RuntimeException: Illegal character: Q
 *
 *  % java VIN 1FA-CP45E-G-LF192944
 *  Exception in thread "main" java.lang.RuntimeException: Illegal check digit: G
 *
 *  % java VIN 1FA-CP45E-X-LF19294
 *  Exception in thread "main" java.lang.RuntimeException: VIN number must be 17 characters
 *
 ******************************************************************************/

public class VIN {
    public static void main(String[] args) {
        int[] values = { 1, 2, 3, 4, 5, 6, 7, 8, 0, 1,
                         2, 3, 4, 5, 0, 7, 0, 9, 2, 3,
                         4, 5, 6, 7, 8, 9 };
        int[] weights = { 8, 7, 6, 5, 4, 3, 2, 10, 0, 9,
                          8, 7, 6, 5, 4, 3, 2 };

        String s = args[0];
        s = s.replaceAll("-", "");
        s = s.toUpperCase();
        if (s.length() != 17)
            throw new RuntimeException("VIN number must be 17 characters");

        int sum = 0;
        for (int i = 0; i < 17; i++) {
            char c = s.charAt(i);
            int value;
            int weight = weights[i];

            // letter
            if (c >= 'A' && c <= 'Z') {
                value = values[c - 'A'];
                if (value == 0)
                    throw new RuntimeException("Illegal character: " + c);
            }

            // number
            else if (c >= '0' && c <= '9') value = c - '0';

            // illegal character
            else throw new RuntimeException("Illegal character: " + c);

            sum = sum + weight * value;

        }

        // check digit
        sum = sum % 11;
        char check = s.charAt(8);
        if (check != 'X' && (check < '0' || check > '9'))
            throw new RuntimeException("Illegal check digit: " + check);
        if      (sum == 10 && check == 'X') StdOut.println("Valid");
        else if (sum == check - '0')        StdOut.println("Valid");
        else                                StdOut.println("Invalid");

    }

}
