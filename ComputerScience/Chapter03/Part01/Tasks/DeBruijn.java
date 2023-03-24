/******************************************************************************
 *  Compilation:  javac DeBruijn.java
 *  Execution:    java DeBruijn n
 *
 *  Print out a de Bruijn sequence of order n. This is a shortest
 *  (circular) string such that every sequence of n bits appears
 *  as a substring at least once.
 *
 *  Algorithm: start with n 0's. Append a 1 if the n-tuple that
 *  would be formed has not already appeared in the sequence;
 *  append a 0 otherwise.
 *
 *  Note: not the most space or time efficient algorithm.
 *
 *  % java DeBruijn 4
 *  0000111101100101
 *
 *  % java DeBruijn 5
 *  00000111110111001101011000101001
 *
 *  % java DeBruijn 6
 *  0000001111110111100111010111000110110100110010110000101010001001
 *
 ******************************************************************************/

public class DeBruijn {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        String deBruijn = "";
        for (int i = 0; i < n; i++)
            deBruijn = deBruijn + "0";

        for (int i = n; i < (1 << n); i++) {
            String suffix = deBruijn.substring(i - n + 1);
            if (deBruijn.indexOf(suffix + "1") == -1)
                deBruijn = deBruijn + "1";
            else
                deBruijn = deBruijn + "0";
        }
        StdOut.println(deBruijn);

    }

}
