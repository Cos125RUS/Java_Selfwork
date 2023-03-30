import java.util.ArrayList;

public class MoveBalls {
    public static void main(String[] args) {
        StdDraw.enableDoubleBuffering();

        Ball b1 = new Ball(0.480, 0.860, 0.01, 0.023, 0.05);
        Ball b2 = new Ball(0.680, 0.260, 0.01, 0.023, 0.05);
        Ball b3 = new Ball(0.280, 0.460, 0.01, 0.023, 0.05);
        Ball b4 = new Ball(0.512, 0.760, 0.01, 0.023, 0.05);
        Ball b5 = new Ball(0.100, 0.567, 0.01, 0.023, 0.05);

        ArrayList<Ball> lb = new ArrayList<>();

        lb.add(b1);
        lb.add(b2);
        lb.add(b3);
        lb.add(b4);
        lb.add(b5);

        while (true) {
            for (Ball b : lb) {
                b.move();
            }

            StdDraw.clear(StdDraw.LIGHT_GRAY);

            StdDraw.setPenColor(StdDraw.BLACK);

            for (Ball b : lb) {
                b.filledCircle();
            }

            StdDraw.show();

            StdDraw.pause(20);
        }
    }
}
