public class Task4_3_6 {
    public static void main(String[] args) {
        String line = args[0];
        StdOut.println(check(line));
    }

    public static boolean check(String line){
        char open[] = {'(', '{', '['};
        char close[] = {')', '}', ']'};
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            Boolean flag = false;
            for (int j = 0; j < open.length; j++){
                if (open[j] == c){
                    s.push(c);
                    flag = true;
                    break;
                }
            }
            if (!flag){
                for (int j = 0; j < 3; j++){
                    if (close[j] == c){
                        if (s.pop() != open[j])
                            return false;
                    }
                }
            }
        }

        return true;
    }
}
