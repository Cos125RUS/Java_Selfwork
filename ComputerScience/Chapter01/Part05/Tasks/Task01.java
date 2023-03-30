public class Task01 {
    public static void main(String[] args) {
        int max = Integer.parseInt(args[0]);
        int min = Integer.parseInt(args[0]);
        for (String s : args) {
            int n = Integer.parseInt(s);
            if (n > max) max = n;
            if (n < min) min = n;
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
    }
}
