/******************************************************************************
 *  Compilation:  javac Subsequence.java
 *  Execution:    java Subsequence s t
 *
 *  Determines whether string s is a subsequence of string t.
 *
 ******************************************************************************/


public class Subsequence {
    public static boolean isSubsequence(String s, String t) {
        int m = s.length();
        int n = t.length();

        int i = 0;
        for (int j = 0; j < n; j++) {
            if (s.charAt(i) == t.charAt(j)) i++;
            if (i == m) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = args[0];
        String t = args[1];
        StdOut.println(isSubsequence(s, t));
    }

}
