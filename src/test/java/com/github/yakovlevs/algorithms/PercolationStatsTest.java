package com.github.yakovlevs.algorithms;

import com.github.yakovlevs.algorithms.PercolationStats;
import org.junit.Before;
import org.junit.Test;


public class PercolationStatsTest {
  private PercolationStats ps;

  @Before
  public void main() {
    ps = new PercolationStats(200, 100);
  }

  @Test
  public void mean() {
    System.out.println("mean: " + ps.mean());
  }

  @Test
  public void stddev() {
    System.out.println("stddev: " + ps.stddev());
  }

  @Test
  public void confidenceLo() {
    System.out.println("Lo: " + ps.confidenceLo());
  }

  @Test
  public void confidenceHi() {
    System.out.println("Hi: " + ps.confidenceHi());
  }


  @Test
  public void set2048() {
    PercolationStats ps = new PercolationStats(2048, 1);
  }
}