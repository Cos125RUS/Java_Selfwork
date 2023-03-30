/******************************************************************************
 *  Compilation:  javac CouponExperiment.java
 *  Execution:    java CouponExperiment trials
 *
 *  % java CouponExperiment 1000
 *           N    average    stdddev         mu      sigma
 *  ------------------------------------------------------
 *           2          3          1        3.0        2.6
 *           4          8          4        8.3        5.1
 *           8         21          8       21.7       10.3
 *          16         54         19       54.1       20.5
 *          32        131         41      129.9       41.0
 *          64        302         79      303.6       82.1
 *         128        692        156      695.4      164.2
 *         256       1583        326     1567.8      328.3
 *         512       3477        643     3490.1      656.7
 *        1024       7634       1310     7689.4     1313.3
 *        2048      16843       2561    16797.9     2626.7
 *        4096      36879       5377    36434.3     5253.3
 *        8192      78447      10317    78546.5    10506.6
 *       16384     169028      21771   168448.9    21013.3
 *       32768     359625      45291   359610.4    42026.6
 *       65536     762705      81625   764646.4    84053.2
 *
 ******************************************************************************/

public class CouponExperiment {
    public static void main(String[] args) {

        // number of times to repeat each experiment
        int trials = Integer.parseInt(args[0]);

        StdOut.printf("%10s %10s %10s %10s %10s\n", "n", "average", "stdddev", "mu", "sigma");
        StdOut.println("------------------------------------------------------");
        for (int n = 2; true; n *= 2) {

            // do specified number of trials and store results in an array
            double[] results = new double[trials];
            for (int t = 0; t < trials; t++) {
                results[t] = Coupon.collect(n);
            }

            // compute statistics
            double mu     = StdStats.mean(results);
            double sigma  = StdStats.stddev(results);

            // theoretical values
            double mean   = n * Harmonic.harmonic(n);
            double stddev = n * Math.PI / Math.sqrt(6.0);

            // print results
            StdOut.printf("%10d %10.0f %10.0f %10.1f %10.1f\n", n, mu, sigma, mean, stddev);
        }
    }
}

