public class RandomIntSeq {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int n = Integer.parseInt(args[1]);
        for (int i = 0; i < n; i++) {
            System.out.println((int)(Math.random() * (m - 1)));
        }
    }
}
