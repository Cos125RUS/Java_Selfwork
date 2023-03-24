/******************************************************************************
 *  Compilation:  javac Shuffle.java
 *  Execution:    java Shuffle arg1 arg2 arg3
 *
 *  Prints out the command line arguments in random order.
 *  Uses a function that takes an array and rearranges it
 *  in random order.
 *
 *  % java Shuffle Alice Bob Cynthia Dan Erin Frank
 *  Bob
 *  Frank
 *  Dan
 *  Cynthia
 *  Alice
 *  Erin
 *
 *  % java Shuffle Alice Bob Cynthia Dan Erin Frank
 *  Cynthia
 *  Alice
 *  Frank
 *  Dan
 *  Erin
 *  Bob
 *
 ******************************************************************************/

public class Shuffle {

    // swaps array elements i and j
    public static void exchange(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // returns a random integer between 0 and n-1
    public static int uniformInt(int n) {
        return (int) (Math.random() * n);
    }

    // take as input an array of strings and rearrange them in random order
    public static void shuffle(String[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + uniformInt(n-i);   // between i and n-1
            exchange(a, i, r);
        }
    }

    // take as input an array of strings and print them out to standard output
    public static void show(String[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.println(a[i]);
        }
    }

    // shuffle the command line arguments
    public static void main(String[] args) {
        shuffle(args);
        show(args);

    }
}
