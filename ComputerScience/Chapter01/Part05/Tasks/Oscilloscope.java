/******************************************************************************
 *  Compilation:  javac Oscilloscope.java
 *  Execution:    java Oscilloscope a b wX wY phiX phiY
 *  Dependencies: StdDraw.java
 *
 *  Simluate the output of an oscilloscope. Assume that the vertical and
 *  horizontal inputs are sinusoidal.
 *
 *        x = a sin (wX + phiX)
 *        y = b sin (wY + phiY)
 *
 *  % java Oscilloscope 1 1 2 3 20 45
 *
 ******************************************************************************/

public class Oscilloscope {

    public static void main(String[] args) {
        StdDraw.setXscale(-1, +1);
        StdDraw.setYscale(-1, +1);
        StdDraw.enableDoubleBuffering();

        double a    = Double.parseDouble(args[0]);    // amplitudes
        double b    = Double.parseDouble(args[1]);
        double wX   = Double.parseDouble(args[2]);    // angular frequencies
        double wY   = Double.parseDouble(args[3]);
        double phiX = Double.parseDouble(args[4]);    // phase factors
        double phiY = Double.parseDouble(args[5]);

        // convert from degrees to radians
        phiY = Math.toRadians(phiX);
        phiY = Math.toRadians(phiY);


        for (double t = 0.0; t < 10; t += 0.0001) {
            double x = a * Math.sin(wX * t + phiX);
            double y = b * Math.sin(wY * t + phiY);
            StdDraw.point(x, y);
            StdDraw.show();
            StdDraw.pause(10);
        }
    }

}
