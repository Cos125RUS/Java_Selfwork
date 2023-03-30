/******************************************************************************
 *  Compilation:  javac FieldLines.java
 *  Execution:    java FieldLines n
 *  Dependencies: https://introcs.cs.princeton.edu/32class/DeluxeCharge.java
 *
 *  Written by Kevin Wayne and Zhijin Liu.
 *
 ******************************************************************************/

import java.awt.Color;

public class FieldLines {

    public static void main(String[] args) {
        int SIZE = 250;                     // size of window
        double RADIUS = 500E-12;            // real size (m)
        int FIELD_LINES = 16;               // number of fields per charge to draw
        double eps = RADIUS / SIZE;         // real size of 1 pixel
        double EPSILON = eps / 1.0E5;
        double e = 1.60217733E-19;          // elementary charge (C)

        // n random charges
        int n = Integer.parseInt(args[0]);
        DeluxeCharge[] charges = new DeluxeCharge[n];
        for (int i = 0; i < n; i++) {
            double x = Math.random() * RADIUS;
            double y = Math.random() * RADIUS;
            double k = e;
            if (Math.random() < 0.5) k = -e;
            charges[i] = new DeluxeCharge(x, y, k);
        }


        charges[0] = new DeluxeCharge(RADIUS/2, RADIUS/2 + RADIUS/8,  e);
        charges[1] = new DeluxeCharge(RADIUS/2, RADIUS/2 - RADIUS/8,  -e);


/*
      // Helium nucleus and two nearby electrons
        charges[0] = new DeluxeCharge(RADIUS/2, RADIUS/2,          e);
        charges[1] = new DeluxeCharge(RADIUS/2, RADIUS/2,          e);
        charges[2] = new DeluxeCharge(RADIUS/2, RADIUS/2,          0);
        charges[3] = new DeluxeCharge(RADIUS/2, RADIUS/2,          0);
        charges[4] = new DeluxeCharge(RADIUS/2+128e-12, RADIUS/2, -e);
        charges[5] = new DeluxeCharge(RADIUS/2, RADIUS/2+128e-12, -e);
*/


/*
      // 3 dipoles
        charges[0] = new DeluxeCharge(RADIUS/4 - 8e-12, RADIUS/4,        e);
        charges[1] = new DeluxeCharge(RADIUS/4 + 8e-12, RADIUS/4,       -e);
        charges[2] = new DeluxeCharge(RADIUS/4 - 8e-12, RADIUS*3/4,      e);
        charges[3] = new DeluxeCharge(RADIUS/4 + 8e-12, RADIUS*3/4,     -e);
        charges[4] = new DeluxeCharge(RADIUS*3/4,       RADIUS/2+8e-12,  e);
        charges[5] = new DeluxeCharge(RADIUS*3/4,       RADIUS/2-8e-12, -e);
*/

        StdDraw.setCanvasSize(SIZE, SIZE);
        StdDraw.setXscale(0, SIZE);
        StdDraw.setYscale(0, SIZE);

        // compute potential at each gridpoint (x, y)
        for (int ix = 0; ix < SIZE; ix++) {
            for (int iy = 0; iy < SIZE; iy++) {
                double x = ix * RADIUS / SIZE;
                double y = iy * RADIUS / SIZE;
                double V = 0.0;
                for (int i = 0; i < n; i++) {
                    V += charges[i].potentialAt(x, y);
                }

                // draw potential according in color from red to blue
                int h = 120 - (int) (V * 3);
                if (h < 0)   h = 0;
                if (h > 240) h = 240;
                Color color = Color.getHSBColor(h / 360.0f, 1.0f, 1.0f);
                StdDraw.setPenColor(color);
                StdDraw.point(ix, iy);
            }
        }

        StdDraw.show();

        // draw field lines
        StdDraw.setPenColor(StdDraw.WHITE);
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < FIELD_LINES; k++) {

                // start the lines on a circle around the charge
                // perhaps add randomAngle = Math.random(); to each angle to avoid
                // degenerate case and infinite loop with 2 equal and aligned charges
                double x = charges[j].getX() + eps * Math.cos(2 * Math.PI * k / FIELD_LINES);
                double y = charges[j].getY() + eps * Math.sin(2 * Math.PI * k / FIELD_LINES);
                boolean reachedAnotherCharge = false;
                // Check for infinite loop
                boolean infiniteLoop = false;
                int count = 0;
                double[] oldXs = { 0.0, 0.0 };
                double[] oldYs = { 0.0, 0.0 };

                while (!reachedAnotherCharge && !infiniteLoop
                        && x > 0 && x < RADIUS && y > 0 && y < RADIUS) {

                    // find the field (Ex, Ey) and field strength E at (x,y)
                    double Ex = 0.0, Ey = 0.0;
                    for (int i = 0; i < n; i++) {
                        Ex += charges[i].fieldX(x, y);
                        Ey += charges[i].fieldY(x, y);
                    }
                    double E = Math.sqrt(Ex * Ex + Ey * Ey);

                    // if charge is negative the line needs to go backwards
                    if (charges[j].isPositivelyCharged()) {
                        x += Ex / E * eps;
                        y += Ey / E * eps;
                    }
                    else {
                        x -= Ex / E * eps;
                        y -= Ey / E * eps;
                    }
                    StdDraw.point(x / eps, y / eps);

                    // stop in infinite loop
                    if (Math.abs(x - oldXs[0]) < EPSILON && Math.abs(y - oldYs[0]) < EPSILON) {
                        infiniteLoop = true;
                    }
                    int index = count++ % 2;
                    oldXs[index] = x;
                    oldYs[index] = y;

                    // stop if the line ends in a charge
                    for (int i = 0; i < n; i++)
                        if (charges[i].distanceTo(x, y) < eps) reachedAnotherCharge = true;
                }
            }
        }
        StdDraw.show();
        // StdDraw.save("dipole.png");
    }
}
