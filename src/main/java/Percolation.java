public class Percolation {
    private final int n;
    private final Site[][] parent;
    private int countOpenSites = 0;
    private final Site top = new Site();
    private final Site bottom = new Site();

    // create n-by-n parent, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        parent = new Site[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                parent[i][j] = new Site();
            }
        }
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        checkIndices(row, col);
        if (isOpen(row, col)) return;
        int i = row - 1;
        int j = col - 1;
        Site s = parent[i][j];
        s.setOpen(true);
        if (i == 0) {
            union(top, s);
        }

        // union with upper site
        if ((i > 0) && isOpen(row - 1, col)) {
            union(s, parent[i - 1][j]);
        }
        // union with lower site
        if ((i < (n - 1)) && isOpen(row + 1, col)) {
            union(s, parent[i + 1][j]);
        }
        // union with left site
        if ((j > 0) && isOpen(row, col - 1)) {
            union(s, parent[i][j - 1]);
        }
        // union with right site
        if ((j < (n - 1)) && isOpen(row, col + 1)) {
            union(s, parent[i][j + 1]);
        }
        countOpenSites++;

        for (int k = 1; k <= n; k++) {
            if (isFull(n, k)) {
                union(bottom, parent[n - 1][k - 1]);
                break;
            }
        }
    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        checkIndices(row, col);
        return parent[row - 1][col - 1].isOpen();
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        checkIndices(row, col);
        return connected(top, parent[row - 1][col - 1]);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return countOpenSites;
    }

    // does the system percolate?
    public boolean percolates() {
        return connected(top, bottom);
    }

    private void checkIndices(int row, int col) {
        if ((row > n) || (col > n) || (col <= 0) || (row <= 0)) {
            throw new IllegalArgumentException();
        }
    }

    private Site root(Site s) {
        while (s != s.getParent())
            s = s.getParent();
        return s;
    }

    private boolean connected(Site p, Site q) {
        return root(p) == root(q);
    }

    private void union(Site p, Site q) {
        Site rootP = root(p);
        Site rootQ = root(q);
        if (rootP == rootQ) return;

        // make smaller root point to larger one
        if (rootP.getSize() < rootQ.getSize()) {
            rootP.setParent(rootQ);
            rootQ.setSize(rootP.getSize() + rootQ.getSize());
        } else {
            rootQ.setParent(rootP);
            rootP.setSize(rootQ.getSize() + rootP.getSize());
        }
    }

    private class Site {
        private Site parent;
        private boolean open = false;
        private int size = 1;

        public Site() {
            this.parent = this;
        }

        public Site getParent() {
            return parent;
        }

        public void setParent(Site parent) {
            this.parent = parent;
        }

        public boolean isOpen() {
            return open;
        }

        public void setOpen(boolean open) {
            this.open = open;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}
