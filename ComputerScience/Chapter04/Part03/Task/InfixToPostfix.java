/******************************************************************************
 *  Compilation:  javac InfixToPostfix.java
 *  Execution:    java InfixToPostfix
 *  Dependencies: Stack.java StdIn.java
 *
 *  Reads in an infix expression and outputs an equivalent postfix
 *  expression.
 *
 *  Windows users: replace <Ctrl-d> with <Ctrl-z> so signify end of file.
 *
 *  % java InfixToPostfix
 *  ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 *  <Ctrl-d>
 *  2 3 4 + 5 6 * * +
 *
 *  % java InfixToPostfix | java EvaluatePostfix
 *  ( 2 + ( ( 3 + 4 ) * ( 5 * 6 ) ) )
 *  <Ctrl-d>
 *  212
 *
 ******************************************************************************/

public class InfixToPostfix {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if      (s.equals("+")) stack.push(s);
            else if (s.equals("*")) stack.push(s);
            else if (s.equals(")")) StdOut.print(stack.pop() + " ");
            else if (s.equals("(")) StdOut.print("");
            else                    StdOut.print(s + " ");
        }
        StdOut.println();
    }
}

