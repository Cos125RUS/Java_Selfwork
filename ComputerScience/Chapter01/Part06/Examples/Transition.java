import java.util.Scanner;

public class Transition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] counts = new int[n][n];
        int[] outDegrees = new int[n];
        while (scanner.hasNext()) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            counts[i][j]++;
            outDegrees[i]++;
        }

        System.out.println(n + " " + n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                double p = 0.9 * counts[i][j] / outDegrees[i] + 0.1 / n;
                StdOut.printf("%8.5f", p);
            }
            System.out.println();
        }
    }
}
