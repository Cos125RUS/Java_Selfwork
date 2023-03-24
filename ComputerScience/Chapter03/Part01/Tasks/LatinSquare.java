/******************************************************************************
 *  Compilation:  javac LatinSquare.java
 *  Execution:    java LatinSquare n
 *
 *  % java LatinSquare 5
 *  A B C D E
 *  B C D E A
 *  C D E A B
 *  D E A B C
 *  E A B C D
 *
 *  Limitations
 *  -----------
 *   - n is at most 26
 *
 ******************************************************************************/

public class LatinSquare {

    public static void main(String[] args) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int n = Integer.parseInt(args[0]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = alphabet.charAt((i + j) % n);
                StdOut.print(c + " ");
            }
            StdOut.println();
        }
    }
}
