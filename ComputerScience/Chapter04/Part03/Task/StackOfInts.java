/******************************************************************************
 *  Compilation:  javac StackOfInts.java
 *  Execution:    java StackOfInts
 *
 *  A stack of integers implemented using a linked list.
 *
 ******************************************************************************/

public class StackOfInts {
    private Node first;        // top of stack

    // linked list node helper data type
    private class Node {
        private int  item;
        private Node next;
    }

    // create an empty stack
    public StackOfInts() {
        first = null;
    }

    // is the stack empty?
    public boolean isEmpty() {
        return first == null;
    }

    // add an element to the stack
    public void push(int item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
    }

    // delete and return the most recently added element
    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack underflow");
        int item = first.item;         // save item to return
        first = first.next;            // delete first node
        return item;                   // return the saved item
    }


}

