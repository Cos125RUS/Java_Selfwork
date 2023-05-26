/******************************************************************************
 *  Compilation:  javac SequentialSearchArrayST.java
 *  Execution:    java SequentialSearchArrayST
 *
 *  Symbol table implementation with unordered array. Uses repeated
 *  doubling to resize the array.
 *
 *  % java SequentialSearchArrayST
 *  128.112.136.11
 *  208.216.181.15
 *  null
 *
 ******************************************************************************/


public class SequentialSearchArrayST<Key, Value> {
    private static final int INIT_SIZE = 8;

    private Key[] keys;     // symbol table keys
    private Value[] vals;   // symbol table values
    private int n = 0;      // number of elements in symbol table

    public SequentialSearchArrayST() {
        keys = (Key[]) new Object[INIT_SIZE];
        vals = (Value[]) new Object[INIT_SIZE];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    private void resize(int capacity) {
        Key[] tempk = (Key[]) new Object[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++)
            tempk[i] = keys[i];
        for (int i = 0; i < n; i++)
            tempv[i] = vals[i];
        keys = tempk;
        vals = tempv;
    }


    public void put(Key key, Value val) {

        // to deal with duplicates
        remove(key);

        // double size of arrays if necessary
        if (n >= vals.length) resize(2*n);

        // add new key and value at the end of array
        vals[n] = val;
        keys[n] = key;
        n++;
    }

    // return value associated with given key (or null if no such key)
    public Value get(Key key) {
        for (int i = 0; i < n; i++)
            if (keys[i].equals(key)) return vals[i];
        return null;
    }

    // is the given key in the symbol table?
    public boolean contains(Key key) {
        return get(key) != null;
    }

    // return number of elements
    public int size() {
        return n;
    }

    // remove given key and return associated value
    public void remove(Key key) {
        for (int i = 0; i < n; i++) {
            if (key.equals(keys[i])) {
                keys[i] = keys[n-1];
                vals[i] = vals[n-1];
                keys[n-1] = null;
                vals[n-1] = null;
                n--;
                return;
            }
        }
    }

    // all keys, as an Iterable
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (int i = 0; i < n; i++)
            queue.enqueue(keys[i]);
        return queue;
    }


   /***************************************************************************
    * Test routine.
    ***************************************************************************/
    public static void main(String[] args) {
        SequentialSearchArrayST<String, String> st = new SequentialSearchArrayST<String, String>();

        // insert some key-value pairs
        st.put("www.cs.princeton.edu", "128.112.136.11");
        st.put("www.princeton.edu",    "128.112.128.15");
        st.put("www.yale.edu",         "130.132.143.21");
        st.put("www.amazon.com",       "208.216.181.15");
        st.put("www.simpsons.com",     "209.052.165.60");

        // search for IP addresses given URL
        StdOut.println(st.get("www.cs.princeton.edu"));
        StdOut.println(st.get("www.amazon.com"));
        StdOut.println(st.get("www.amazon.edu"));

    }

}
