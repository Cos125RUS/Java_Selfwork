/******************************************************************************
 *  Compilation:  javac Perfect.java
 *  Execution:    java Perfect
 *
 *  Searches for an odd perfect number. A perfect number is an integer
 *  that is equal to the sum of its proper divisors. For example, 28
 *  is perfect since 28 = 1 + 2 + 4 + 7 + 14.
 *
 *  Will this program terminate, assuming overflow never occurs?
 *
 *  % java Perfect 3
 *  The sum of the divisors of 1 is 0
 *  The sum of the divisors of 4 is 3
 *  The sum of the divisors of 7 is 1
 *  The sum of the divisors of 10 is 8
 *  The sum of the divisors of 13 is 1
 *  The sum of the divisors of 16 is 15
 *  The sum of the divisors of 19 is 1
 *  The sum of the divisors of 22 is 14
 *  The sum of the divisors of 25 is 6
 *  The sum of the divisors of 28 is 28
 *
 *  % java Perfect 1
 *
 *  In the 18th century Euler proved that all *even* perfect numbers
 *  are of the form (2^k - 1) * 2^(k-1) for some k. It is unknown whether
 *  there are infinitely many of these. It is conjectured that no odd
 *  perfect number exists. If one exists, it must be greater than 10^300.
 *
 *  http://www.wikipedia.org/wiki/Perfect_number
 *
 *
 ******************************************************************************/

public class Perfect {

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);

        for (long n = 1; true; n = n + x) {
            long sum = 0;
            for (long i = 1; i < n; i++)
                if (n % i == 0) sum = sum + i;
            StdOut.println("The sum of the divisors of " + n + " is " + sum);
            if (sum == n) break;
        }
    }
}
