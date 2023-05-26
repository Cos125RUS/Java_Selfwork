/******************************************************************************
 *  Compilation:  javac ExceptionFilter.java
 *  Execution:    java ExceptionFilter words.txt < file.txt
 *  Dependencies: SET In.java StdIn.java
 *
 *  Read in a list of words from a file. Then read in a list of
 *  words from standard input and print out all those words that
 *  are not in the first file.
 *
 ******************************************************************************/

public class ExceptionFilter {
    public static void main(String[] args) {
        SET<String> set = new SET<String>();

        // read in strings and add to set
        In in = new In(args[0]);
        while (!in.isEmpty()) {
            String word = in.readString();
            set.add(word);
        }

        // read in string from standard input, printing out all exceptions
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (!set.contains(word))
                StdOut.println(word);
        }
    }
}
