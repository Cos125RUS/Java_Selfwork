/******************************************************************************
 *  Compilation:  javac TwoSum.java
 *  Execution:    java TwoSum < input.txt
 *                java Generator n | java TwoSum
 *
 *  A program with cubic running time. Read in n integers
 *  and counts the number of pairs that sum to exactly 0.
 *
 *  Limitations
 *  -----------
 *     - we ignore integer overflow
 *
 *  Sample data files
 *  -----------------
 *  https://introcs.cs.princeton.edu/java/41analysis/8ints.txt
 *  https://introcs.cs.princeton.edu/java/41analysis/1Kints.txt
 *  https://introcs.cs.princeton.edu/java/41analysis/2Kints.txt
 *  https://introcs.cs.princeton.edu/java/41analysis/4Kints.txt
 *  https://introcs.cs.princeton.edu/java/41analysis/8Kints.txt
 *  https://introcs.cs.princeton.edu/java/41analysis/16Kints.txt
 *  https://introcs.cs.princeton.edu/java/41analysis/32Kints.txt
 *  https://introcs.cs.princeton.edu/java/41analysis/64Kints.txt
 *  https://introcs.cs.princeton.edu/java/41analysis/128Kints.txt
 *
 *  Use the program Generator.java to generate additional data files.
 *
 ******************************************************************************/

public class TwoSum {

    // print distinct pairs (i, j) such that a[i] + a[j]  = 0
    public static void printAll(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (a[i] + a[j] == 0) {
                    StdOut.println(a[i] + " " + a[j]);
                }
            }
        }
    }

    // return number of distinct pairs (i, j) such that a[i] + a[j] = 0
    public static int count(int[] a) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (a[i] + a[j] == 0) {
                    count++;
                }
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
