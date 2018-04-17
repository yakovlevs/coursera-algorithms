import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private int gridSize = 0;
    private boolean[][] grid;
    private int countOpenSites = 0;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        gridSize = n;
        grid = new boolean[n][n];
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        checkIndices(row, col);
        grid[row - 1][col - 1] = true;
        countOpenSites++;
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkIndices(row, col);
        return grid[row][col];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        checkIndices(row, col);
        if (isOpen(row,col)){

        }
        return false;
    }

    // number of open sites
    public int numberOfOpenSites() {
        return countOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {

    }

    private void checkIndices(int row, int col) {
        if ((row > gridSize) || (col > gridSize)) {
            throw new IllegalArgumentException();
        }
    }

    public void printGrid() {
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j]) {
                    System.out.print("○ ");
                } else {
                    System.out.print("● ");
                }
            }
            System.out.println("");
        }
    }
}
