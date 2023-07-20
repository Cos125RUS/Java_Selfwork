/******************************************************************************
 *  Compilation:  javac Harvester.java
 *  Execution:    java Harvester regexp url
 *  Dependencies: In.java
 *
 *  Downloads the web page and prints out all strings that
 *  match the specified pattern.
 *
 *  % java Harvester "[a-z]+@([a-z]+\.)+(edu|com|biz|tv)" http://www.cs.princeton.edu/courses/archive/fall05/cos126/precepts.html
 *  frances@cs.princeton.edu
 *  fcole@cs.princeton.edu
 *  hlarsen@cs.princeton.edu
 *  aslp@cs.princeton.edu
 *  dgabai@cs.princeton.edu
 *  dgabai@cs.princeton.edu
 *  chuttenh@cs.princeton.edu
 *  ebanks@cs.princeton.edu
 *
 *  %  java Harvester "GCG(CGG|AGG)*CTG" chromosomeX.txt
 *  GCGCGGAGGCGGCGGCGGCGGCGGAGGCGGCGGCTG
 *  GCGCGGCGGAGGCTG
 *
 ******************************************************************************/

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Harvester {

    public static void main(String[] args) {
        String regexp = args[0];
        In in = new In(args[1]);
        String input = in.readAll();

        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String s = matcher.group();
            StdOut.println(s);
        }
    }

}
