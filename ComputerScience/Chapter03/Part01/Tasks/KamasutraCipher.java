/******************************************************************************
 *  Compilation:  javac KamasutraCipher.java
 *  Execution:    java KamasutraCipher key1 key2
 *
 *  Encode a message using the Kamasutra cipher.
 *
 *  % java KamasutraCipher THEQUICKBROWN FXJMPSVLAZYDG
 *  MEET AT ELEVEN
 *  QJJF BF JKJCJG
 *
 ******************************************************************************/

public class KamasutraCipher {

    public static void main(String[] args) {
        String top = args[0];
        String bot = args[1];

        while (StdIn.hasNextLine()) {
            String s = StdIn.readLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if      (top.indexOf(c) >= 0) StdOut.print(bot.charAt(top.indexOf(c)));
                else if (bot.indexOf(c) >= 0) StdOut.print(top.charAt(bot.indexOf(c)));
                else                          StdOut.print(c);
            }
            StdOut.println();
        }
    }
}
