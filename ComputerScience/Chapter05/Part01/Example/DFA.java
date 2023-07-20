/******************************************************************************
 *  Compilation:  javac DFA.java
 *  Execution:    java DFA filename < input.txt
 *  Dependencies: StdOut.java StdIn.java In.java
 *  Data files:   https://introcs.cs.princeton.edu/java/51language/b3.txt
 *                https://introcs.cs.princeton.edu/java/51language/gene.txt
 *
 *  This program simulates the operation of the DFA specified as the
 *  first command-line argument for each of the lines on standard input.
 *  It prints Yes if the string is in the language specified by the DFA
 *  and No otherwise.
 *
 *  % more b3.txt 3
 *  ab
 *  Yes 0 1
 *  No 1 2 No 2 0
 *
 *  % java DFA b3.txt
 *  babbbabb
 *  Yes
 *  babbb
 *  No
 *
 ******************************************************************************/

public class DFA {
    private String[] action;
    private ST<Character, Integer>[] next;

    public DFA(String filename) {
        In in = new In(filename);
        int n = in.readInt();
        String alphabet = in.readString();
        action = new String[n];
        next = (ST<Character, Integer>[]) new ST[n];
        for (int state = 0; state < n; state++) {
            action[state] = in.readString();
            next[state] = new ST<Character, Integer>();
            for (int i = 0; i < alphabet.length(); i++)
                next[state].put(alphabet.charAt(i), in.readInt());
        }
    }

    public String simulate(String input) {
       int state = 0;
       for (int i = 0; i < input.length(); i++)
           state = next[state].get(input.charAt(i));
       return action[state];
    }

    public static void main(String[] args) {
        DFA dfa = new DFA(args[0]);
        while (StdIn.hasNextLine()) {
            String line = StdIn.readLine();
            StdOut.println(dfa.simulate(line));
        }
    }
}
