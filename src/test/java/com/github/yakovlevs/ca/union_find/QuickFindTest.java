package com.github.yakovlevs.ca.union_find;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickFindTest {

    private void  unionFindTest(UnionFind uf){
        uf.union(0, 1);
        assertTrue(uf.connected(0, 1));
        assertTrue(!uf.connected(1, 2));
        uf.union(2, 3);
        assertTrue(uf.connected(2, 3));
        assertTrue(!uf.connected(1, 2));
        uf.union(0, 3);
        assertTrue(uf.connected(1, 2));
    }

    @Test
    public void quickFindTest() {
        UnionFind uf = new QuickFind(4);
        unionFindTest(uf);
    }

    @Test
    public void quickUnionTest() {
        UnionFind uf = new QuickUnion(4);
        unionFindTest(uf);
    }

    @Test
    public void quickUnionWeightedTest() {
        UnionFind uf = new QuickUnionWeighted(4);
        unionFindTest(uf);
    }

    @Test
    public void quickUnionWeightedPathCompressedTest() {
        UnionFind uf = new QuickUnionWeightedPathCompressed(4);
        unionFindTest(uf);
    }
}