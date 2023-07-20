// L-system weed
/*
   Weed {
       Angle 50
       Axiom +++++++++++++x
       x=f[@.5+++++++++x]-f[@.4-----------!x]@.6x
   }
*/

// Diego Nehab

public class LSystem {
    private double da = 360.0/50.0;
    private Turtle turtle;

    public LSystem(int N) {
        turtle = new Turtle(256, 30, 13*da);
        turtle.setXscale(0, 512);
        turtle.setYscale(0, 512);
        L(70, 1, N);
    }

    private void L(double ds, int dir, int n) {
        if (n > 0) {
            turtle.goForward(ds);
            turtle.turnLeft(9*dir*da);
            L(0.5*ds, dir, n-1);
            turtle.turnLeft(-10*dir*da);
            turtle.goForward(ds);
            turtle.turnLeft(-11*dir*da);
            L(0.4*ds, -dir, n-1);
            turtle.turnLeft(11*dir*da);
            L(0.6*ds, dir, n-1);
            turtle.goForward(-ds);
            turtle.turnLeft(dir*da);
            turtle.goForward(-ds);
        }
    }

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        new LSystem(N);
    }
}
