/******************************************************************************
 *  Compilation:  javac SubsetSum.java
 *  Execution:    java SubsetSum < input.txt
 *
 *  A program with exponential running time. Reads n long integers
 *  and find the number of subset whose sum is exactly 9.
 *
 *  Limitations
 *  -----------
 *     - we assume no sum of n integers will overflow a long
 *
 ******************************************************************************/

public class SubsetSum {

    public static void main(String[] args) {

        // read in input data
        long[] a = StdIn.readAllLongs();
        int n = a.length;

        // number of subsets that sum to exactly 0
        int count = 0;
        for (int k = 1; k < (1 << n); k++)  {
            long sum = 0;
            for (int i = 0; i < n; i++)
                if (((k >> i) & 1) == 1) sum = sum + a[i];
            if (sum == 0)
                count++;
        }
        StdOut.println(count);


    }

}
