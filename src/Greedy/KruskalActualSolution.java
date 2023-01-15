//package Greedy;
//
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.HashSet;
//import java.util.Set;
//
//public class KruskalActualSolution {
//
//    /**
//     * The function you should change. The old return line has already been commented and a result
//     * variable created for you.
//     *
//     * @param n the number of nodes
//     * @param m the number of edges
//     * @param k the number of clusters to make
//     * @param nodes the nodes, indexed 1 to n (with ids 1 to n)
//     * @param edges the edges, indexed 1 to m
//     * @return the set of clusters, each cluster is a set of Nodes.
//     */
//    public static Set<Set<Node>> getMeMyClusters(int n, int m, int k, Node[] nodes, gettingOutTheFastest.Edge[] edges) {
//        UnionFind unionFind = new UnionFind(n + 1);
//        // Sort by shortest distance
//        Arrays.sort(edges, 1, m, Comparator.comparingLong(e -> e.weight));
//        Set<Set<Node>> nodes = new HashSet<>();
//        int cost = 0;
//        int count = 0;
//        for (int j = 1; j <= m; j++) {
//            gettingOutTheFastest.Edge e = edges[j];
//            if (count == n - k) break;
//            if (unionFind.union(e.a, e.b)) {
//                count++;
//                cost += e.weight;
//            }
//        }
//        // return cost;
//        Set<Set<Node>> result = new HashSet<>();
//        // TODO
//
//        return result;
//    }
//
//}
