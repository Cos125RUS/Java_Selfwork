/******************************************************************************
 *  Compilation:  javac NoConvergence.java
 *  Execution:    java NoConvergence n
 *
 *  A recursive function whose reduction step does not converge to the
 *  base case.
 *
 *  % java NoConvergence 5
 *  Exception in thread "main" java.lang.StackOverflowError
 *          at NoConvergence.harmonic(NoConvergence.java:19)
 *          at NoConvergence.harmonic(NoConvergence.java:20)
 *          at NoConvergence.harmonic(NoConvergence.java:20)
 *          ...
 ******************************************************************************/

public class NoConvergence {

    public static double harmonic(int n) {
        if (n == 1) return 1.0;
        return harmonic(n) + 1.0/n;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(harmonic(n));
    }

}
