/******************************************************************************
 *  Compilation:  javac FrequencyCounter.java
 *  Execution:    java FrequencyCounter < input.txt
 *  Dependencies: ST.java StdIn.java
 *
 *  Read in a list of words from standard input and print out
 *  each word and the number of times it appears.
 *
 *  % java FrequencyCounter < mobydick.txt | sort -rn | more
 *  13527 the
 *  6374 of
 *  5857 and
 *  4457 a
 *  4388 to
 *  3773 in
 *  2666 that
 *  ...
 *
 ******************************************************************************/

public class FrequencyCounter {


    public static void main(String[] args) {
        ST<String, Integer> st = new ST<String, Integer>();

        // compute frequency counts
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (st.contains(key)) st.put(key, st.get(key) + 1);
            else                  st.put(key, 1);
        }

        // print out results
        for (String s : st)
            StdOut.println(st.get(s) + " " + s);

        // StdOut.println(st.size() + " distinct keys (red black)");
    }
}
