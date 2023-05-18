/******************************************************************************
 *  Compilation:  javac CircularQuote.java
 *  Execution:    java CircularQuote
 *  Dependencies: none
 *
 *  Code for a circular linked list using a nested Node class.
 *
 ******************************************************************************/

public class CircularQuote {

    // the first node in the circular linked list; null if empty
    private Node start;

    // helper linked-list data type
    private class Node {
        private String word;    // the word associated with the node
        private Node next;      // the next node in the linked list

        public Node(String word) {
            this.word = word;
            this.next = null;
        }
    }

    // create an empty quote
    public CircularQuote() {
        start = null;
    }

    // add the specified word to the end of the quote
    public void addWord(String word) {
        Node newNode = new Node(word);

        // degenerate case for empty quote
        if (start == null) {
            start = newNode;
            start.next = start;
        }

        // otherwise
        else {

            // find the "last" node in the circular linked list
            Node x = start;
            do {
                x = x.next;
            } while (x.next != start);

            // insert new node
            newNode.next = start;
            x.next = newNode;
        }
    }

    // number of words in the quote
    public int count() {

        // empty quote
        if (start == null) return 0;

        Node x = start;
        int total = 0;
        do {
            total++;
            x = x.next;
        } while (x != start);
        return total;
    }

    // the ith word in the quote (where i = 1 is the first word)
    public String getWord(int i) {
        if (i > count() || i <= 0) throw new RuntimeException("index out of bounds");

        Node x = start;
        for (int j = 1; j < i; j++) {
            x = x.next;
        }
        return x.word;
    }

    // insert the specified word after the ith word (where i = 1 is the first word)
    public void insertWord(int i, String word) {
        if (i > count() || i <= 0) throw new RuntimeException("index out of bounds");

        Node newNode = new Node(word);

        // find the ith node
        Node x = start;
        for (int j = 1; j < i; j++) {
            x = x.next;
        }

        // insert node between x and x.next
        newNode.next = x.next;
        x.next = newNode;
    }

    // string representation of the entire quote
    public String toString() {
        String s = "";
        if (start == null) return s;

        Node x = start;
        do {
            s = s + x.word + " ";
            x = x.next;
        } while (x != start);
        return s;
    }

    // test client
    public static void main(String[] args) {
        CircularQuote quote = new CircularQuote();
        quote.addWord("A");
        quote.addWord("rose");
        quote.addWord("is");
        quote.addWord("a");
        quote.addWord("rose.");
        StdOut.println(quote);
        StdOut.println(quote.count());
        StdOut.println(quote.getWord(2));
        quote.insertWord(3, "just");
        StdOut.println(quote);
        StdOut.println(quote.count());
    }
}

