package com.github.yakovlevs.ca.union_find;

// N*N operations - very slow
public class QuickFind implements UnionFind {
    private int[] id;

    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int p_id = id[p];
        int q_id = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == p_id) {
                id[i] = q_id;
            }
        }
    }
}
