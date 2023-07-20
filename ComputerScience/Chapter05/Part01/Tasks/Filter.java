/******************************************************************************
 *  Compilation:  javac Filter.java
 *  Execution:    java Filter < input.txt
 *  Dependencies: In.java
 *
 *  Remove all characters that aren't alphanumeric or whitespace.
 *
 ******************************************************************************/

public class Filter {

    public static void main(String[] args) {
        String regexp = "[^\\s0-9a-zA-Z]";  // whitespace or alpha-numeric

        // read input
        In in = new In();
        String input = in.readAll();

        // create and print output
        String output = input.replaceAll(regexp, "");
        StdOut.println(output);
    }

}
