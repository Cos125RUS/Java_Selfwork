/******************************************************************************
 *  Compilation:  javac BouncingColoredBalls.java
 *  Execution:    java BouncingColoredBalls n
 *  Dependencies: ColoredBall.java StdDraw.java
 *
 *  Creates an array of n bouncing balls and animates them.
 *
 *  % java BouncingBalls 10
 *
 ******************************************************************************/

public class BouncingColoredBalls {

    public static void main(String[] args) {

        // number of bouncing balls
        int n = Integer.parseInt(args[0]);

        // set boundary to box with coordinates between -1 and +1
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);

        // create an array of n random colored balls
        ColoredBall[] balls = new ColoredBall[n];
        for (int i = 0; i < n; i++)
            balls[i] = new ColoredBall();

        // do the animation loop
        StdDraw.enableDoubleBuffering();
        while (true) {

            // move the n balls
            for (int i = 0; i < n; i++) {
                balls[i].move();
            }

            // draw the n balls
            StdDraw.clear(StdDraw.GRAY);
            StdDraw.setPenColor(StdDraw.BLACK);
            for (int i = 0; i < n; i++) {
                balls[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
}
