
/******************************************************************************
 *  Compilation:  javac Cellular.java
 *  Execution:    java Cellular N
 *
 *  Simulates and prints N steps of the Rule 90 cellular automaton.
 *
 *  Sample output:  java Cellular 10
 *
 *              *
 *             * *
 *            *   *
 *           * * * *
 *          *       *
 *         * *     * *
 *        *   *   *   *
 *       * * * * * * * *
 *      *               *
 *
 *
 *
 ******************************************************************************/

public class Cellular {
   public static void main(String[] args) {
      int N = Integer.parseInt(args[0]);
      int CELLS = 2 * N;

      boolean[] cells = new boolean[CELLS];      // cellular automaton at time t
      boolean[] old   = new boolean[CELLS];      // cellular automaton at time t-1
      cells[CELLS/2] = true;

      for (int t = 1; t < N; t++) {

         // draw current row
         for (int i = 0; i < CELLS; i++) {
            if(cells[i]) StdOut.print("*");
            else         StdOut.print(" ");
         }
         StdOut.println("");

         // save current row
         for (int i = 0; i < CELLS; i++)
            old[i] = cells[i];

         // update cells according to rule 90
         for (int i = 1; i < CELLS - 1; i++)
            cells[i] = old[i-1] ^ old[i+1];      // ^ means XOR
      }
   }
}
