/******************************************************************************
 *  Compilation:  javac Directory.java
 *  Execution:    java Directory directory-name
 *  Dependencies: Queue.java
 *
 *  Prints out all of the files in the given directory and any
 *  subdirectories in level-order by using a queue. Also prints
 *  out their file sizes in bytes.
 *
 *  % java Directory .
 *
 ******************************************************************************/

import java.io.File;

public class Directory {

    public static void main(String[] args) {
        Queue<File> queue = new Queue<File>();
        File root = new File(args[0]);     // root directory
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            File directory = queue.dequeue();
            File[] files = directory.listFiles();
            if (files != null) {
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isDirectory()) queue.enqueue(files[i]);
                    else StdOut.println(files[i].length() + ":\t" + files[i]);
                }
            }
        }
    }

}
