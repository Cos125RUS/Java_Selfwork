/******************************************************************************
 *  Compilation:  javac ExcessiveMemory.java
 *  Execution:    java ExcessiveMemory n
 *
 *  A recursive function that consumes excessive stack space to compute
 *  the result.
 *
 *  % java ExcessiveMemory 5000
 *  Exception in thread "main" java.lang.StackOverflowError
 *          at ExcessiveMemory.harmonic(ExcessiveMemory.java:19)
 *          at ExcessiveMemory.harmonic(ExcessiveMemory.java:20)
 *          at ExcessiveMemory.harmonic(ExcessiveMemory.java:20)
 *          ...
 ******************************************************************************/

public class ExcessiveMemory {

    public static double harmonic(int n) {
        if (n == 1) return 1.0;
        return harmonic(n-1) + 1.0/n;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdOut.println(harmonic(n));
    }

}
