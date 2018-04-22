package com.github.yakovlevs.algorithms.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

//import java.lang.reflect.Field;

public class Percolation {
  private final int size;
  private final boolean[] open;
  private final WeightedQuickUnionUF qu;
  private int countOpenSites = 0;

  // create size-by-size parent, with all sites blocked
  public Percolation(int size) {
    if (size <= 0) {
      throw new IllegalArgumentException();
    }
    qu = new WeightedQuickUnionUF(size * size + 2);
    this.size = size;
    open = new boolean[size * size];

  }

  // open site (row, col) if it is not open already
  public void open(int row, int col) {
    checkIndices(row, col);
    if (isOpen(row, col)) {
      return;
    }

    int siteCurrent = size * (row - 1) + col;

    countOpenSites++;
    open[size * (row - 1) + col - 1] = true;

    if (row == 1) {
      // union with fake top site
      qu.union(0, siteCurrent);
    }
    // union with upper site
    if ((row > 1) && isOpen(row - 1, col)) {
      int siteUpper = size * (row - 2) + col;
      qu.union(siteCurrent, siteUpper);
    }
    // union with lower site
    if ((row < size) && isOpen(row + 1, col)) {
      int siteLower = size * (row) + col;
      qu.union(siteCurrent, siteLower);
    }
    // union with left site
    if ((col > 1) && isOpen(row, col - 1)) {
      int siteLeft = size * (row - 1) + col - 1;
      qu.union(siteCurrent, siteLeft);
    }
    // union with right site
    if ((col < size) && isOpen(row, col + 1)) {
      int siteRight = size * (row - 1) + col + 1;
      qu.union(siteCurrent, siteRight);
    }
  }


  // is site (row, col) open?
  public boolean isOpen(int row, int col) {
    checkIndices(row, col);
    return open[size * (row - 1) + col - 1];
  }

  // is site (row, col) full?
  public boolean isFull(int row, int col) {
    checkIndices(row, col);
    int siteCurrent = size * (row - 1) + col;
    return qu.connected(0, siteCurrent);
  }

  // number of open sites
  public int numberOfOpenSites() {
    return countOpenSites;
  }

  // does the system percolate?
  public boolean percolates() {
    for (int k = 1; k <= size; k++) {
      if (isFull(size, k)) {
        return true;
      }
    }
    return false;
  }

  private void checkIndices(int row, int col) {
    if ((row > size) || (col > size) || (col <= 0) || (row <= 0)) {
      throw new IllegalArgumentException();
    }
  }
}
