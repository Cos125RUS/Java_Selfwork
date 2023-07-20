/******************************************************************************
 *  Compilation:  javac Clean.java
 *  Execution:    java Clean in.txt out.txt
 *  Dependencies: In.java
 *
 *  Reads in the text file in.txt and writes it back to the file out.txt,
 *  replacing tabs with 4 spaces and removing and trailing whitespace.
 *
 ******************************************************************************/

public class Clean {

    public static void main(String[] args) {
        In in   = new In(args[0]);
        Out out = new Out(args[1]);
        while (in.hasNextLine()) {
            String s = in.readLine();
            s = s.replaceAll("\\t", "    ");
            s = s.replaceAll("\\s+$", "");
            out.println(s);
        }
    }

}
