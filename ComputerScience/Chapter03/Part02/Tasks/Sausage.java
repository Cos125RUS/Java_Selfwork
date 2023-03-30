/******************************************************************************
 *  Compilation:  javac Sausage.java
 *  Execution:    java Sausage n
 *  Dependencies: StdDraw.java
 *
 *  Plot an order n Minkowski sausage.
 *
 *  % java Sausage 5
 *
 ******************************************************************************/


public class Sausage {
    private Turtle turtle;
    private double size;

    public Sausage(int n) {
        size = 1.5 / Math.pow(4.0 / Math.sqrt(3), n+1);
        turtle = new Turtle(90/512.0, 150/512.0, 0.0);
        sausage(n);
        turtle.turnLeft(90);
        sausage(n);
        turtle.turnLeft(90);
        sausage(n);
        turtle.turnLeft(90);
        sausage(n);
        turtle.turnLeft(90);
    }


    private void sausage(int n) {
        if (n == 0) turtle.goForward(size);
        else {
            turtle.turnLeft(-30);
            sausage(n-1);
            turtle.turnLeft(90);
            sausage(n-1);
            turtle.turnLeft(-90);
            sausage(n-1);
            turtle.turnLeft(30);
        }
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        new Sausage(n);
    }
}
