/******************************************************************************
 *  Compilation:  javac WidthChecker.java
 *  Execution:    java WidthChecker n < source.java
 *  Dependencies: StdIn.java
 *
 *  Reads in a text file and prints out all lines that have (strictly)
 *  more than n characters (including spaces but not the newline
 *  character itself).
 *
 *  Note: setting n = -1 prints out all lines with line numbers.
 *
 ******************************************************************************/

public class WidthChecker {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);       // max line length

        for (int count = 1; !StdIn.isEmpty(); count++) {
            String line = StdIn.readLine();      // read in next line
            if (line.length() > n)               // line exceeds threshold
                StdOut.println(count + ": " + line);
        }
    }

}
