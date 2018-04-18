import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PercolationStats {
    private int[] results;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if ((n <= 0) || (trials <= 0)) {
            throw new IllegalArgumentException();
        }
        results = new int[trials];
        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            while (!p.percolates()){
                p.open(1+StdRandom.uniform(n),1+StdRandom.uniform(n));
            }
            results[i] = p.numberOfOpenSites();
            if (results[i] >= (n*n)){
                System.out.println("-----results "+i+":  "+results[i]);
                p.printGrid();
                System.out.println("-------------------");
            }
        }
        System.out.println(Arrays.toString(results));
    }

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