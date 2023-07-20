/******************************************************************************
 *  Compilation:  javac Title.java
 *  Execution:    java Title url
 *  Dependencies: In.java
 *
 *  Replace all the text between the title tags in uppercase.
 *
 ******************************************************************************/

public class Title {

    public static void main(String[] args) {
        In in = new In(args[0]);
        String input = in.readAll();
        String regexp = "(?i)(<title.*?>)(.+?)(</title>)";
        String update = input.replaceAll(regexp, ("$2").toUpperCase());
        StdOut.println(update);
    }
}
