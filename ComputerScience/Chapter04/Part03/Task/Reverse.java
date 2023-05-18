/******************************************************************************
 *  Compilation:  javac Reverse.java
 *  Execution:    java Reverse < data.txt
 *  Dependencies: Stack.java
 *
 *  Reads in a sequence of strings from standard input and
 *  and prints them in reverse order to standard output.
 *
 *  %  java Reverse
 *  it was the best of times
 *  [ctrl-d]
 *  times
 *  of
 *  best
 *  the
 *  was
 *  it
 *
 ******************************************************************************/

public class Reverse {

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            stack.push(s);
        }
        while (!stack.isEmpty()) {
            String s = stack.pop();
            StdOut.println(s);
        }
    }

}
