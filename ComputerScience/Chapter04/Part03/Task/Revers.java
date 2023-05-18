

public class Revers {
    public static void main(String[] args) {
        Stack<String> words = new Stack<>();
        while(!StdIn.isEmpty()){
            words.push(StdIn.readString());
        }        

        for (String string : words)
            StdOut.print(words.pop() + ' ');
    }
}
