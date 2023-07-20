/******************************************************************************
 *  Compilation:  javac SearchAndReplace.java In.java
 *  Execution:    java SearchAndReplace from to < input.txt
 *
 *  Replaces all occurrence of the "from" string with the "to"
 *  string.
 *
 ******************************************************************************/

public class SearchAndReplace {


    public static void main(String[] args) {
        String regexp = args[0];
        String to = args[1];

        // read input
        In in = new In();
        String input = in.readAll();

        // create and print output
        String output = input.replaceAll(regexp, to);
        StdOut.println(output);
    }

}
