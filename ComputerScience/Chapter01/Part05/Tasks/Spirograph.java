/******************************************************************************
 *  Compilation:  javac Spirograph.java
 *  Execution:    java Spirograph R r a
 *  Dependencies: StdDraw.java
 *
 *  Draw a curve formed by rolling a smaller circle of radius r inside
 *  a larger circle or radius R. If the pen offset of the pen point in
 *  the moving circle is a, then the equation of the resulting curve
 *  at time t is
 *
 *     x = (R-r)*cos(t) + r*a*cos(((R+r)/r)*t)
 *     y = (R-r)*sin(t) - r*a*sin(((R+r)/r)*t)
 *
 *  Credits: idea suggested by Diego Nehab
 *  Reference: https://sciencedemos.org.uk/spirograph.php
 *
 ******************************************************************************/


public class Spirograph {

    public static void main(String[] args) {
    }

}
