import org.junit.Test;

import static org.junit.Assert.*;

public class PercolationTest {
    @Test
    public void open() throws Exception {
        Percolation p = new Percolation(4);
        p.open(1, 1);
        p.open(4, 4);
        p.open(1, 4);
        p.open(4, 1);
        p.printGrid();
    }

    @Test(expected = IllegalArgumentException.class)
    public void openBoundsCheck() throws Exception {
        Percolation p = new Percolation(4);
        p.open(1, 5);
    }

    @Test
    public void isOpen() throws Exception {
    }

    @Test
    public void isFull() throws Exception {
    }

    @Test
    public void numberOfOpenSites() throws Exception {
        Percolation p = new Percolation(4);
        p.open(1, 1);
        assertEquals(1, p.numberOfOpenSites());
        p.open(4, 4);
        assertEquals(2, p.numberOfOpenSites());
    }

    @Test
    public void percolates() throws Exception {
        Percolation p = new Percolation(4);
        p.printGrid();
    }

    @Test(expected = IllegalArgumentException.class)
    public void percolatesGridSizeCheck() throws Exception {
        Percolation p = new Percolation(0);
    }

}