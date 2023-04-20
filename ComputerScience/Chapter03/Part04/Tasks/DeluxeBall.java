/******************************************************************************
 *  Compilation:  javac DeluxeBall.java
 *  Execution:    java DeluxeBall
 *  Dependencies: StdDraw.java
 *
 *  Implementation of a 2-d ball moving in square with coordinates
 *  between -1 and +1. Bounces off the walls upon collision. This
 *  versions include friction, damping, and drag.
 *
 *
 ******************************************************************************/

import java.awt.Color;

public class DeluxeBall {

    // instance variables
    private double rx, ry;         // position
    private double vx, vy;         // velocity
    private final double radius;   // radius
    private final Color color;     // color

    // constructor
    public DeluxeBall() {
        rx = 0.0;
        ry = 0.0;
        vx = StdRandom.uniformDouble(-0.025, 0.025);
        vy = StdRandom.uniformDouble(-0.025, 0.025);
        radius = StdRandom.uniformDouble(0.05, 0.15);
        color = Color.getHSBColor((float) StdRandom.uniformDouble(0.0, 1.0), 0.8f, 0.8f);
    }

    // move the ball one step
    public void move() {
        double damp = 0.99;
        double friction = 0.97;
        double gravity = 0.01;
        vx *= damp;
        vy *= damp;
        vy -= gravity;
        if (Math.abs(rx + vx * friction) + radius > 1.0) vx = -vx;
        if (Math.abs(ry + vy * friction) + radius > 1.0) vy = -vy;
        rx = rx + vx * friction;
        ry = ry + vy * friction;
    }

    // draw the ball
    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(rx, ry, radius);
    }



    // test client
    public static void main(String[] args) {

        // create and initialize two balls
        DeluxeBall b1 = new DeluxeBall();
        DeluxeBall b2 = new DeluxeBall();

        // animate them
        StdDraw.setXscale(-1.0, +1.0);
        StdDraw.setYscale(-1.0, +1.0);
        StdDraw.enableDoubleBuffering();

        while (true) {
            b1.move();
            b2.move();
            StdDraw.setPenColor(StdDraw.GRAY);
            StdDraw.filledSquare(0.0, 0.0, 1.0);
            StdDraw.setPenColor(StdDraw.BLACK);
            b1.draw();
            b2.draw();
            StdDraw.show();
            StdDraw.pause(50);
        }
    }
}
