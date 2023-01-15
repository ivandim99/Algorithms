package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class phorests {

    /**
     * Optimizes the provided Phorest to be as close to an MST as possible.
     *
     * @param nodes the number of nodes in the network
     * @param m the number of nodes in the network
     * @param graph all edges in the full graph from index 1 to m
     * @param p the number of edges in the Phorest
     * @param phorest the edges in the Phorest from index 1 to p
     * @return total edge weight of optimized Phorest
     */
    public static int solve(int nodes, int m, Edge[] graph, int p, Edge[] phorest) {
        UnionFind unionFind = new UnionFind(nodes);
        int ret = 0;
        int clusters = nodes;
        for(int i = 1; i <= p;i++) {
            if(unionFind.join(phorest[i].x,phorest[i].y))
                clusters--;
                ret += phorest[i].l;
        }

        Arrays.sort(graph,1,m+1, Comparator.comparingInt(e -> e.l));

        for (int i = 1; i <= m; i++) {
            Edge e = graph[i];
            if(unionFind.join(e.x,e.y)) {
                ret += e.l;
                clusters--;
            }
            if(clusters == 1) break;
        }
        return ret;
    }

    protected static class Edge {

        // from, to and length
        int x, y, l;

        public Edge(int from, int to, int length) {
            x = from;
            y = to;
            l = length;
        }
    }

    static class UnionFind {

        private int[] parent;

        private int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        // returns false if x and y are in same set
        private boolean join(int x, int y) {
            int xrt = find(x);
            int yrt = find(y);
            if (rank[xrt] > rank[yrt]) parent[yrt] = xrt;
            else if (rank[xrt] < rank[yrt]) parent[xrt] = yrt;
            else if (xrt != yrt) rank[parent[yrt] = xrt]++;
            return xrt != yrt;
        }

        private int find(int x) {
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }
    }

}
