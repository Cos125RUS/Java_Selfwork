/******************************************************************************
 *  Compilation:  javac Grep.java
 *  Execution:    java Grep pattern file
 *
 *  Fore each line in the given file, check whether any part of the
 *  line matches the pattern, and if so, print out the whole line.
 *  Behaves in a similar manner to the Unix utility grep.
 *
 *  % java Grep "..oo..oo." /usr/dict/words
 *  bloodroot
 *  schoolbook
 *  schoolroom
 *
 *  %  java Grep "a.*e.*i.*o.*u" /usr/dict/words
 *  adventitious
 *  facetious
 *  sacrilegious
 *
 *
 ******************************************************************************/

public class Grep {

    public static void main(String[] args) {
        String regexp = ".*" + args[0] + ".*";
        In in = new In(args[1]);
        while (in.hasNextLine()) {
            String line = in.readLine();
            if (line.matches(regexp))
                StdOut.println(line);
        }
    }

}
