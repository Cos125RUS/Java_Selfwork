/******************************************************************************
 *  Compilation:  javac Cube.java
 *  Execution:    java Cube
 *
 *  Searches for an integer solution to 313(a^3 + b^3) = c^3.
 *  Will this program terminate, assuming overflow never occurs?
 *
 *  % java Cube
 *
 ******************************************************************************/

public class Cube {

    public static void main(String[] args) {
        boolean done = false;
        for (long c = 1; !done; c++)
            for (long a = 1; a < c; a++)
                for (long b = 1; b < c; b++)
                    if (313 * (a*a*a + b*b*b) == c*c*c) done = true;
   }

}
