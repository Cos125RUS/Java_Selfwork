/******************************************************************************
 *  Compilation:  javac SingleHilbert.java
 *  Execution:    java SingleHilbert n
 *  Dependencies: StdDraw.java
 *
 *  Plot an order n Hilbert curve using a singly recursive function.
 *
 *  % java SingleHilbert 5
 *
 *
 ******************************************************************************/


public class SingleHilbert {
    private Turtle turtle;

    public SingleHilbert(int n) {
        turtle = new Turtle(0.5, 0.5, 0.0);
        double max = Math.pow(2, n);
        turtle.setXscale(0, max);
        turtle.setYscale(0, max);
        hilbert(n, +1);
    }

    public void hilbert(int n, int parity) {
        if (n == 0) return;
        turtle.turnLeft(parity * 90);
        hilbert(n-1, -parity);
        turtle.goForward(1.0);
        turtle.turnLeft(-parity * 90);
        hilbert(n-1, +parity);
        turtle.goForward(1.0);
        hilbert(n-1, +parity);
        turtle.turnLeft(-parity * 90);
        turtle.goForward(1.0);
        hilbert(n-1, -parity);
        turtle.turnLeft(parity * 90);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        new SingleHilbert(n);
    }
}
