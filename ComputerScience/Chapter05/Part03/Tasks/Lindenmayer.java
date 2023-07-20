/******************************************************************************
 *  Compilation:  javac Lindenmayer.java
 *  Execution:    java Lindenmayer N
 *
 *  Print out the commands for trying a Koch snowflake of order N using
 *  the Lindenmayer system:
 *
 *        initial string:    F+F--F+F
 *        replacement rule:  F -> F+F--F+F
 *
 *  % java Lindenmayer 1
 *  F+F--F+F--F+F--F+F--F+F--F+F
 *
 *  % java Lindenmayer 2
 *  F+F--F+F+F+F--F+F--F+F--F+F+F+F--F+F--F+F--F+F+F+F--F+F--F+F--F+F+F+F--F+F--F+F--F+F+F+F--F+F--F+F--F+F+F+F--F+F
 *
 ******************************************************************************/

public class Lindenmayer {


    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        String s       = "F--F--F";
        String replace = "F";
        String with    = "F+F--F+F";

        for (int i = 0; i < N; i++)
            s = s.replaceAll(replace, with);
        StdOut.println(s);
    }

}
