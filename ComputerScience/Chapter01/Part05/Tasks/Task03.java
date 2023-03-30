public class Task03 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double[] array = new double[n];
        double average = 0.0;
        for (int i = 0; i < n; i++) {
            array[i] = StdIn.readDouble();
            average += array[i];
        }
        System.out.println("Average = " + average / n);

        double averageSquare = 0.0;
        for (double f : array)
            averageSquare += Math.pow(average - f, 2.0);
        System.out.println("Average Squares = " + (Math.sqrt(averageSquare) / n - 1));
        
    }
}
