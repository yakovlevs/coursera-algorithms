import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {
    private final double[] a;
    private static final double CONF_95 = 1.96d;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if ((n <= 0) || (trials <= 0)) {
            throw new IllegalArgumentException();
        }
        a = new double[trials];
        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()) {
                p.open(1 + StdRandom.uniform(n), 1 + StdRandom.uniform(n));
            }
            a[i] = 1.d * p.numberOfOpenSites() / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(a);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(a);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        double s = stddev();
        double avg = mean();
        return avg - (CONF_95 * s) / Math.sqrt(a.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        double s = stddev();
        double avg = mean();
        return avg + (CONF_95 * s) / Math.sqrt(a.length);
    }

    public static void main(String[] args) {

    }

}