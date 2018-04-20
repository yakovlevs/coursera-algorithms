import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

import java.lang.reflect.Field;

public class Percolation {
    private final int n;
    private final boolean[] open;
    private final WeightedQuickUnionUF qu;
    private int countOpenSites = 0;
    //private int[] parent = new int[0];

    // create n-by-n parent, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        qu = new WeightedQuickUnionUF(n * n + 2);
        this.n = n;
        open = new boolean[n * n];
       /* try {
            Field f = qu.getClass().getDeclaredField("parent"); //NoSuchFieldException
            f.setAccessible(true);
            parent = (int[]) f.get(qu); //IllegalAccessException
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        checkIndices(row, col);
        if (isOpen(row, col)) return;

        int siteCurrent = n * (row - 1) + col;

        countOpenSites++;
        open[n * (row - 1) + col - 1] = true;

        if (row == 1) {
            // union with fake top site
            qu.union(0, siteCurrent);
        }
        // union with upper site
        if ((row > 1) && isOpen(row - 1, col)) {
            int siteUpper = n * (row - 2) + col;
            qu.union(siteCurrent, siteUpper);
        }
        // union with lower site
        if ((row < n) && isOpen(row + 1, col)) {
            int siteLower = n * (row) + col;
            qu.union(siteCurrent, siteLower);
        }
        // union with left site
        if ((col > 1) && isOpen(row, col - 1)) {
            int siteLeft = n * (row - 1) + col - 1;
            qu.union(siteCurrent, siteLeft);
        }
        // union with right site
        if ((col < n) && isOpen(row, col + 1)) {
            int siteRight = n * (row - 1) + col + 1;
            qu.union(siteCurrent, siteRight);
        }
        //printStuff();
    }

   /* private void printStuff() {
        System.out.println("");
        System.out.println("Parent");
        for (int k = 1; k < n * n + 1; k++) {
            System.out.print(parent[k] + " ");
            if (k % n == 0) System.out.println("");
        }

        System.out.println("");
        System.out.println("isFull");
        for (int k = 1; k <= n * n; k++) {
            System.out.print((isFull(k / n + 1, k % n) ? "o" : "x") + " ");
            if (k % n == 0) System.out.println("");
        }
    }*/

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkIndices(row, col);
        return open[n * (row - 1) + col - 1];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        int siteCurrent = n * (row - 1) + col;
        return qu.connected(0, siteCurrent);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return countOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        for (int k = 1; k <= n; k++) {
            if (isFull(n, k)) {
                return true;
            }
        }
        return false;
    }

    private void checkIndices(int row, int col) {
        if ((row > n) || (col > n) || (col <= 0) || (row <= 0)) {
            throw new IllegalArgumentException();
        }
    }
}
