/******************************************************************************
 *  Compilation:  javac Rose.java
 *  Execution:    java Rose n
 *  Dependencies: StdDraw.java
 *
 *  Plots an n petal rose (if n is odd) and a 2n-petal rose if n is
 *  even, using standard graphics.
 *
 ******************************************************************************/

public class Rose {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setXscale(-1, +1);
        StdDraw.setYscale(-1, +1);
        StdDraw.setPenColor(StdDraw.PINK);

        double x0 = 0, y0 = 0;
        for (double t = 0.0; t <= 360.0; t += 0.1) {
            double theta = Math.toRadians(t);
            double r = Math.sin(n * theta);
            double x1 = r * Math.cos(theta);
            double y1 = r * Math.sin(theta);
            StdDraw.line(x0, y0, x1, y1);
            x0 = x1;
            y0 = y1;
        }
    }

}
