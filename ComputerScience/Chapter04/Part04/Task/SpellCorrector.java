/******************************************************************************
 *  Compilation:  javac SpellCorrector.java
 *  Execution:    java SpellCorrector misspellings.txt document.txt
 *  Dependencies: ST.java In.java
 *  Data files:   https://introcs.cs.princeton.edu/java/44st/misspellings.txt
 *                https://introcs.cs.princeton.edu/java/44st/document.txt
 *
 *  Read in a dictionary of misspellings pairs from the file
 *  misspellings.txt and fix the misspelled words in document.txt.
 *
 *  % more misspellings.txt
 *  aberation (aberration)
 *  abondon (abandon)
 *  abondoned (abandoned)
 *  abondons (abandons)
 *  ...
 *  alot (a lot)
 *  ...
 *
 *
 *  % more document.txt
 *  call me ishmael smoe yersa ago never mind how long precisely
 *  hvaing littel or no moeny in my purse
 *  and nothing pariticular to intrest me
 *
 *  % java SpellCorrector misspellings.txt document.txt
 *  call me ishmael (some) (years) ago never mind how long precisely
 *  (having) (little) or no (money) in my purse
 *  and nothing pariticular to (interest) me
 *
 ******************************************************************************/

public class SpellCorrector {
    public static void main(String[] args) {
        ST<String, String> st = new ST<String, String>();

        // read in dictionary of misspelllings
        In in1 = new In(args[0]);
        while (in1.hasNextLine()) {
            String word       = in1.readString();
            String correction = in1.readLine().trim();
            st.put(word, correction);
        }

        // read lines from file and correct misspelled words
        // (replaces sequences of whitespace with single space, but preserves newlines)
        In in2 = new In(args[1]);
        while (in2.hasNextLine()) {
            String line = in2.readLine().trim();
            String[] words = line.split("\\s+");
            for (int i = 0; i < words.length; i++) {
                if (st.contains(words[i])) StdOut.print(st.get(words[i]));
                else                       StdOut.print(words[i]);
                if (i < words.length - 1)  StdOut.print(" ");
            }
            StdOut.println();
        }
    }
}
