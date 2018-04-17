public class PercolationStats {
    public PercolationStats(int n, int trials) {
        if ((n <= 0) || (trials <= 0)) {
            throw new IllegalArgumentException();
        }
    }    // perform trials independent experiments on an n-by-n grid

    // sample mean of percolation threshold
    public double mean() {
        return 0.0d;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return 0.0d;
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return 0.0d;
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return 0.0d;
    }

    // test client (described below)
    public static void main(String[] args) {

    }

}