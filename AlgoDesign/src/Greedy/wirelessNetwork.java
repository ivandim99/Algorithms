package Greedy;

import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class wirelessNetwork {

    static class Solution {

        // Implement the solve method to return the answer to the problem posed by the inputstream.
        public static String run(InputStream in) {
            return new Solution().solve(in);
        }

        public String solve(InputStream in) {
            Scanner sc = new Scanner(in);

            int n = sc.nextInt();
            int m = sc.nextInt();
            int b = sc.nextInt();

            Connection[] conns = new Connection[m];
            Connection[] g = new Connection[n - 1];

            for(int i = 0;i < m;i++) {
                conns[i] = new Connection(sc.nextInt(),sc.nextInt(),sc.nextInt());
            }


            Arrays.sort(conns,Comparator.comparingInt(c -> c.l));

            int count = 0;
            UnionFind unionFind = new UnionFind(n);

            //Kruskal
            for(Connection conn : conns) {
                if(unionFind.join(conn.x,conn.y)) {
                    g[count++] = conn;
                    System.out.println(conn.l);
                }
                if(count == n - 1) {
                    break;
                }
            }

            int min_cost = 0;
            int num_of_conns = 0;

            for(Connection conn: g) {
                min_cost += conn.l;
                if(b >= min_cost) {
                    num_of_conns++;
                }
            }

            return min_cost + " " + num_of_conns;
        }



        private class Connection {
            int x, y, l;

            public Connection(int from, int to, int length) {
                x = from;
                y = to;
                l = length;
            }
        }


        class UnionFind {

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
                if (rank[xrt] > rank[yrt])
                    parent[yrt] = xrt;
                else if (rank[xrt] < rank[yrt])
                    parent[xrt] = yrt;
                else if (xrt != yrt)
                    rank[parent[yrt] = xrt]++;
                return xrt != yrt;
            }

            private int find(int x) {
                return parent[x] == x ? x : (parent[x] = find(parent[x]));
            }
        }

    }

}
