/******************************************************************************
 *  Compilation:  javac Levy.java
 *  Execution:    java Levy n
 *  Dependencies: StdDraw.java
 *
 *  Plot an order n Levy tapestry.
 *
 *  % java Levy 5
 *
 ******************************************************************************/


public class Levy {
    private Turtle turtle;
    private double size;

    public Levy(int n) {
        int SIZE = 512;
        turtle = new Turtle(178, 178, 0);
        turtle.setXscale(0, SIZE);
        turtle.setYscale(0, SIZE);
        size =  156.0 / Math.pow(Math.sqrt(2), n);
        levy(n);
        turtle.turnLeft(90);
        levy(n);
        turtle.turnLeft(90);
        levy(n);
        turtle.turnLeft(90);
        levy(n);
        turtle.turnLeft(90);
    }

    public void levy(int n) {
        if (n == 0) turtle.goForward(size);
        else {
            turtle.turnLeft(-45);
            levy(n-1);
            turtle.turnLeft(90);
            levy(n-1);
            turtle.turnLeft(-45);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        new Levy(n);
    }

}
