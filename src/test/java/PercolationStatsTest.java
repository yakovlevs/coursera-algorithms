import org.junit.Test;

import static org.junit.Assert.*;

public class PercolationStatsTest {

    @Test
    public void mean() {
        PercolationStats ps = new PercolationStats(200, 100);
        System.out.println(ps.mean());
    }

    @Test
    public void stddev() {
        PercolationStats ps = new PercolationStats(200, 100);
        System.out.println(ps.stddev());
    }

    @Test
    public void confidenceLo() {
        PercolationStats ps = new PercolationStats(200, 100);
        System.out.println(ps.confidenceLo());
    }

    @Test
    public void confidenceHi() {
    }

    @Test
    public void main() {
        PercolationStats ps = new PercolationStats(20, 1000);
    }
}