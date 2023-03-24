/******************************************************************************
 *  Compilation:  javac NoBaseCase.java
 *  Execution:    java NoBaseCase n
 *
 *  A recursive function without a base case.
 *
 *  % java NoBaseCase 5
 *  Exception in thread "main" java.lang.StackOverflowError
 *          at NoBaseCase.harmonic(NoBaseCase.java:18)
 *          at NoBaseCase.harmonic(NoBaseCase.java:18)
 *          at NoBaseCase.harmonic(NoBaseCase.java:18)
 *          ...
 ******************************************************************************/

public class NoBaseCase {

    public static double harmonic(int n) {
        return harmonic(n-1) + 1.0/n;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(harmonic(n));
    }

}


