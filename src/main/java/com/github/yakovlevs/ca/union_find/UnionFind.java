package com.github.yakovlevs.ca.union_find;

public interface UnionFind {
    boolean connected(int p, int q);

    void union(int p, int q);
}
