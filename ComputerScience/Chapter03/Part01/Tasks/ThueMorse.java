/******************************************************************************
 *  Compilation:  javac ThueMorse.java
 *  Execution:    java ThueMorse n
 *  Dependencies: StdDraw.java
 *
 *  Plot the n-by-n Thue-Morse weave. The Thue-Morse sequence is
 *  defined as follows:
 *
 *      Start with 0, and repeatedly flip all the bits and concatenate
 *      it onto the original string.
 *
 *  Extend the idea in two dimensions. Plot a black square for 1.
 *
 *  % java ThueMorse 16
 *
 *  % java ThueMorse 128
 *
 ******************************************************************************/

public class ThueMorse {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);     // plot N-by-N grid of cells

       /******************************************************************
        * build up Thue-Morse sequence
        ******************************************************************/
        String thue = "0";
        String morse = "1";
        for (int i = 1; i < n; i *= 2) {
            String t = thue;
            String m = morse;
            thue  += m;
            morse += t;
        }

       /******************************************************************
        * Plot it using StdDraw
        ******************************************************************/
        StdDraw.setXscale(0, n);
        StdDraw.setYscale(0, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (thue.charAt(i) != thue.charAt(j)) {
                    StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                }
            }
        }
        StdDraw.show();
    }

}
