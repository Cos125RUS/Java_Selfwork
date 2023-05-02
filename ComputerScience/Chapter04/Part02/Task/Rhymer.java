/******************************************************************************
 *  Compilation:  javac Rhymer.java StdIn.java
 *  Execution:    java Rhymer < data.txt
 *
 *  Reads in a sequence of words.
 *
 ******************************************************************************/

import java.util.Arrays;

public class Rhymer {


    private static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return new String(sb);
    }


    public static void main(String[] args) {
        String input = StdIn.readAll();
        String[] strings = input.split("\\s+");

        // reverse order of letters in each word
        for (int i = 0; i < strings.length; i++)
            strings[i] = reverse(strings[i]);

        // sort the words
        Arrays.sort(strings);

        // reverse order of letters in each word
        for (int i = 0; i < strings.length; i++)
            strings[i] = reverse(strings[i]);

        // print words
        for (int i = 0; i < strings.length; i++)
            StdOut.println(strings[i]);
    }
}
