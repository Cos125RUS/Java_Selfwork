/******************************************************************************
 *  Compilation:  javac FourChargeClient.java
 *  Execution:    java FourChargeClient r
 *  Dependencies: Charge.java
 *
 *  % java FourChargeClient .1
 *  total potential = 1.5239509122751547E11
 *
 *  %  java FourChargeClient .2
 *  total potential = 2.5593786255292056E11
 *
 ******************************************************************************/

public class FourChargeClient {
    public static void main(String[] args) {
        double r = Double.parseDouble(args[0]);

        // center of standard drawing window
        double cx = 0.5;
        double cy = 0.5;

        // construct four charges
        Charge c1 = new Charge(cx + r, cy,     1.0);    // east
        Charge c2 = new Charge(cx,     cy - r, 1.0);    // south
        Charge c3 = new Charge(cx - r, cy,     1.0);    // west
        Charge c4 = new Charge(cx,     cy + r, 1.0);    // north

        // Compute potentials at (.25, .5)
        double px = 0.25;
        double py = 0.5;
        double v1 = c1.potentialAt(px, py);
        double v2 = c2.potentialAt(px, py);
        double v3 = c3.potentialAt(px, py);
        double v4 = c4.potentialAt(px, py);

        // compute and output total potential
        double sum = v1 + v2 + v3 + v4;
        StdOut.println("total potential = " + sum);
    }
}
