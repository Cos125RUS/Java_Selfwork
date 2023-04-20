/******************************************************************************
 *  Compilation:  javac OneSum.java
 *  Execution:    java OneSum n < input.txt
 *
 *  A program with linear running time. Read in n integers
 *  and find the one closest to 0.
 *
 ******************************************************************************/

public class OneSum {

    // return number of elements that are 0
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args)  {
        int[] a = StdIn.readAllInts();
        int n = a.length;
        Stopwatch timer = new Stopwatch();
        int count = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(count);
    }

}
