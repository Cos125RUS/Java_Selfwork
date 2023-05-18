/******************************************************************************
 *  Compilation:  javac TopologicalSorter.java
 *  Execution:    java TopologicalSorter n < data.txt
 *  Dependencies: Queue.java
 *
 *  Reads in a list of order pairs of integers between 0 and n-1.
 *  The pair (i, j) indicates that i must be scheduled before j.
 *  If there is a total ordering of the integers 0..n-1 that respects
 *  the partial order, then print it out.
 *
 *  The program uses the following algorithm. For each node i, maintain
 *  a queue out[i] of nodes that must be scheduled after i. Also
 *  maintain for each node i the number of nodes indegree[i] that must
 *  be scheduled before i. Keep a queue that contains all of the
 *  nodes with zero indegree. Repeatedly remove a node with zero
 *  indegree, print it out, and decrease by 1 the indegree of all
 *  the nodes in out[i].
 *
 *  % java TopologicalSorter 8 < topological1.txt
 *  Scheduled:          0 3 5 7 4 2 1 6
 *  Could not schedule:
 *
 *  % java TopologicalSorter 8 < topological2.txt
 *  Scheduled:          0 3 5 4
 *  Could not schedule: 1 2 6 7
 *
 ******************************************************************************/

public class TopologicalSorter {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        int[] indegree = new int[n];

        // can't create an array of integer queues
        Queue<Integer>[] out = (Queue<Integer>[]) new Queue[n];

        for (int i = 0; i < n; i++)
            out[i] = new Queue<Integer>();

        // read in the pairs
        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            int j = StdIn.readInt();
            out[i].enqueue(j);
            indegree[j]++;
        }

        // initialize the queue of nodes with 0 indegree
        Queue<Integer> queue = new Queue<Integer>();
        for (int i = 0; i < n; i++)
            if (indegree[i] == 0) queue.enqueue(i);

        // repeatedly find a node with 0 indegree
        StdOut.print("Scheduled:          ");
        while (!queue.isEmpty()) {
            int i = queue.dequeue();
            StdOut.print(i + " ");
            while (!out[i].isEmpty()) {
                int j = out[i].dequeue();
                indegree[j]--;
                if (indegree[j] == 0) queue.enqueue(j);
            }
        }
        StdOut.println();

        // check if any nodes not scheduled
        StdOut.print("Could not schedule: ");
        for (int i = 0; i < n; i++)
            if (indegree[i] > 0) StdOut.print(i + " ");
        StdOut.println();
    }

}
