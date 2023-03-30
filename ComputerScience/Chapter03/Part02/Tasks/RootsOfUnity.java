/******************************************************************************
 *  Compilation:  javac RootsOfUnity.java Complex.java
 *  Execution:    java RootsOfUnity n
 *
 *  Compute the n nth roots of unity and check them by direct
 *  multiplication.
 *
 *  % java RootsOfUnity 4
 *  1.0 + 0.0i
 *  error = 0.0
 *  6.123233995736766E-17 + 1.0i
 *  error = 2.4492935982947064E-16
 *
 *  -1.0 + 1.2246467991473532E-16i
 *  error = 4.898587196589413E-16
 *
 *  -1.8369701987210297E-16 + -1.0i
 *  error = 7.347880794884119E-16
 *
 ******************************************************************************/

class RootsOfUnity {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Complex one = new Complex(1, 0);

        for (int i = 0; i < n; i++) {

            // compute root of unity
            double x = Math.cos(2.0 * Math.PI * i / n);
            double y = Math.sin(2.0 * Math.PI * i / n);
            Complex t = new Complex(x, y);
            StdOut.println(t);

            // test mult by computing t^n and comparing to 1 + 0i
            Complex z = one;
            for (int j = 0; j < n; j++) {
                z = z.times(t);
            }

            // compute error
            Complex error = z.minus(one);
            StdOut.println("error = " + error.abs());
            StdOut.println();
        }
    }
}
