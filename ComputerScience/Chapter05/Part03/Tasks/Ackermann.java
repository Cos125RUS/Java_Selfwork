/******************************************************************************
 *  Compilation:  javac Ackermann.java
 *  Execution:    java Ackermann M N
 *
 *  Calculate the Ackermann function A(M, N) using a straightforward
 *  recursive program.
 *
 *  % java Ackermann 3 8
 *  2045
 *
 *  % java Ackermann 3 9
 *  StackOverflowError
 *
 ******************************************************************************/


public class Ackermann {

   public static long ackermann(long m, long n) {
      if (m == 0) return n + 1;
      if (n == 0) return ackermann(m - 1, 1);
      return ackermann(m - 1, ackermann(m, n - 1));
   }

   public static void main(String[] args) {
      long M = Long.parseLong(args[0]);
      long N = Long.parseLong(args[1]);
      StdOut.println(ackermann(M, N));
   }
}
