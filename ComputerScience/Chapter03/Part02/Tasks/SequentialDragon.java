/******************************************************************************
 *  Compilation:  javac SequentialDragon.java
 *  Execution:    java SequentialDragon n
 *
 *  Prints out instructions for drawing an order n dragon curve.
 *
 *  % java SequentialDragon 0
 *  F
 *
 *  % java SequentialDragon 2
 *  FLFLFRF
 *
 *  % SequentialDragon 5
 *  FLFLFRFLFLFRFRFLFLFLFRFRFLFRFRFLFLFLFRFLFLFRFRFRFLFLFRFRFLFRFRF
 *
 *  Limitations
 *  -------------
 *    -  n must be between 0 and 31
 *
 ******************************************************************************/

public class SequentialDragon {
    public static void main(String[] args) {
        int n  = Integer.parseInt(args[0]);
        StdOut.print("F");
        for (int k = 1; k < (1 << n); k++) {
            if ((k & ((k ^ (k-1)) + 1)) > 0) StdOut.print("R");
            else                             StdOut.print("L");
            StdOut.print("F");
        }
        StdOut.println();
    }
}
