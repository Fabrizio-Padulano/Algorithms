package org.padulano.fabrizio.algorithms.graphs;

import java.util.Arrays;


public class UnionFind {

    /**
     * Please see the leetcode.com/problems/redundant-connection for information
     * @param edges e.g [[1,2],[1,3],[2,3]];
     *              There are no repeated edges;
     *              The given graph is connected;
     *
     */
    public static int[] findRedundantConnection(int[][] edges) {
        int[] par = new int[edges.length + 1];
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }

        int[] rank = new int[edges.length + 1];
        Arrays.fill(rank, 1);

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1], par, rank)) return edge;
        }

        return edges[0];

    }

    private static int find(int n, int[] par) {
        int p = par[n];

        while (p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }

        return p;
    }

    private static boolean union(int n1, int n2, int[] par, int[] rank) {
        int p1 = find(n1, par), p2 = find(n2, par);

        if (p1 == p2) return false;

        if (rank[p1] > rank[p2]) {
            par[p2] = p1;
            rank[p1] += rank[p2];
        } else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }

        return true;
    }
}
