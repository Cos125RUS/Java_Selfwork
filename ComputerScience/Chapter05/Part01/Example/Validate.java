/******************************************************************************
 *  Compilation:  javac Validate.java
 *  Execution:    java Validate pattern < input.txt
 *
 *  Reads in a regular expression and a text input string from the
 *  command line and prints true or false depending on whether
 *  the pattern matches the text.
 *
 *  % java Validate "(a|b)*a(a|b)(a|b)(a|b)(a|b)"
 *  bbbabbbb
 *  [Yes]
 *  bbbbbbbba
 *  [No]
 *
 *  % java Validate "..oo..oo."
 *  bloodroot
 *  [Yes]
 *  nincompoophood
 *  [False]
 *
 *  % java Validate "[^aeiou]{6}"
 *  rhythm
 *  [Yes]
 *  rhythms
 *  [No]
 *
 ******************************************************************************/

public class Validate {

    public static void main(String[] args) {
        String regexp = args[0];
        while (!StdIn.isEmpty()) {
            String text = StdIn.readString();
            if (text.matches(regexp)) StdOut.println("[Yes]");
            else                      StdOut.println("[No]");
        }
    }

}
