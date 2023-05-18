/******************************************************************************
 *  Compilation:  javac Quote.java
 *  Execution:    java Quote
 *  Dependencies: none
 *
 *  Code for a null-terminated linked list, using the nested class Node.
 *
 *  % A rose is a rose.
 *  5
 *  rose
 *  A rose is just a rose.
 *  6
 *
 ******************************************************************************/

public class Quote {

    // the first node in the null-terminated linked list; null if empty
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
    public Quote() {
        start = null;
    }

    // add the specified word to the end of the quote
    public void addWord(String word) {
        Node newNode = new Node(word);

        // degenerate case when quote is empty
        if (start == null) start = newNode;

        // otherwise
        else {

            // traverse linked list until x points to last node
            Node x = start;
            while (x.next != null) {
                x = x.next;
            }

            // add node to the end of list
            x.next = newNode;
        }
    }

    // number of words in the quote
    public int count() {
        int total = 0;
        for (Node x = start; x != null; x = x.next) {
            total++;
        }
        return total;
    }

    // return the ith word in the quote (where i = 1 is the first word)
    public String getWord(int i) {
        if (count() < i || i <= 0) throw new RuntimeException("index out of bounds");

        Node x = start;
        for (int count = 1; count < i; count++) {
            x = x.next;
        }
        return x.word;
    }

    // insert the specified word after the ith word (where i = 1 is the first word)
    public void insertWord(int i, String word) {
        if (count() < i || i <= 0) throw new RuntimeException("index out of bounds");

        Node newNode = new Node(word);
        Node x = start;
        for (int j = 1; j < i; j++) {
            x = x.next;
        }
        newNode.next = x.next;
        x.next = newNode;
    }

    // string representation of the quote
    public String toString() {
        String s = "";
        for (Node x = start; x != null; x = x.next) {
            s = s + x.word + " ";
        }
        return s;
    }



    public static void main(String[] args) {
        Quote quote = new Quote();
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
