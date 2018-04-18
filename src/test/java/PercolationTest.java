import org.junit.Test;

import static org.junit.Assert.*;

public class PercolationTest {
    @Test
    public void open() throws Exception {
        Percolation p = new Percolation(4);
        p.open(1, 1);
        assertTrue(p.isOpen(1, 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void openBoundsCheck() throws Exception {
        Percolation p = new Percolation(4);
        p.open(1, 5);
    }

    @Test
    public void isOpen() throws Exception {
        Percolation p = new Percolation(4);
        p.open(1, 1);
        assertTrue(p.isOpen(1, 1));
        p.open(1, 4);
        assertTrue(p.isOpen(1, 4));
        p.open(1, 4);
        assertEquals(2, p.numberOfOpenSites());
    }

    @Test
    public void isFull() throws Exception {
        Percolation p = new Percolation(4);
        p.open(1, 1);
        assertTrue(p.isFull(1, 1));
        p.open(2, 1);
        assertTrue(p.isFull(2, 1));
        p.open(3, 1);
        assertTrue(p.isFull(3, 1));
        p.open(4, 1);
        assertTrue(p.isFull(4, 1));
        p.open(3,3);
        assertTrue(p.isOpen(3,3));
        assertTrue(!p.isFull(3,3));
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
        p.open(1, 1);
        p.open(2, 1);
        p.open(3, 1);
        p.open(4, 1);
        assertTrue(p.percolates());
    }

    @Test(expected = IllegalArgumentException.class)
    public void percolatesGridSizeCheck() throws Exception {
        Percolation p = new Percolation(0);
    }

}