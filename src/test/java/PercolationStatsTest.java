import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


public class PercolationStatsTest {
    PercolationStats ps;

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

    @Before
    public void main() {
        ps = new PercolationStats(200, 100);
    }
@Ignore
    @Test
    public void set2048() {
        PercolationStats ps = new PercolationStats(2048, 1);
    }
}