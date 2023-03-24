public class Task18 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(n);
        double size = 1 / (2 * (double) n);
        System.out.println(size);
        int  line = 1;
        StdDraw.setCanvasSize(720,720);
        for (double i = size; i < 1; i += size*2) {
            int square = line%2;
            for (Double j = size; j < 1; j += size*2) {
                if (square % 2 == 0) 
                    StdDraw.setPenColor(StdDraw.RED);
                else 
                    StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(j, i, size);
                square++;
            }
            line++;
        }

        // StdDraw.square(0.1, 0.1, .1);
        // StdDraw.filledSquare(0.3, 0.1, .1);
        // StdDraw.square(0.5, 0.1, .1);
        // StdDraw.filledSquare(0.7, 0.1, .1);
        // StdDraw.square(0.9, 0.1, .1);

        // StdDraw.filledSquare(0.1, 0.3, .1);
        // StdDraw.square(0.3, 0.3, .1);
        // StdDraw.filledSquare(0.5, 0.3, .1);
        // StdDraw.square(0.7, 0.3, .1);
        // StdDraw.filledSquare(0.9, 0.3, .1);
    }
}
