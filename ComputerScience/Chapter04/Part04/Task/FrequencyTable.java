/******************************************************************************
 *  Compilation:  javac FrequencyTable
 *  Dependencies: StdIn.java StdOut.java ST.java
 *  Execution:    java FrequencyTable < words.txt
 *  Data file:    https://introcs.cs.princeton.edu/java/44st/mobydick.txt
 *
 *  Read in a list of words from standard input and print out
 *  each word and the number of times it appears.
 *
 *  % java FrequencyTable < mobydick.txt
 *  4583 a
 *  2 aback
 *  2 abaft
 *  3 abandon
 *  7 abandoned
 *  1 abandonedly
 *  2 abandonment
 *  ...
 *
 *  % java FrequencyTable < mobydick.txt | sort -rn | more
 *  13967 the
 *  6415 of
 *  6247 and
 *  4583 a
 *  4508 to
 *  4037 in
 *  2911 that
 *  2481 his
 *  ...
 *
 ******************************************************************************/

public class FrequencyTable {
    private ST<String, Integer> st = new ST<String, Integer>();

    public void increment(String key) {
        int count = frequencyOf(key);
        st.put(key, count + 1);
    }

    // return the number of times the key appears
    public int frequencyOf(String key) {
        if (!st.contains(key)) return 0;
        else return st.get(key);
    }

    // returns a string representation of this frequency table
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String key : st.keys()) {
            sb.append(frequencyOf(key) + " " + key + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        // build frequency table from words on standard input
        FrequencyTable freq = new FrequencyTable();
        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            freq.increment(key);
        }

        // print frequency table to standard output
        StdOut.println(freq);
    }

}
