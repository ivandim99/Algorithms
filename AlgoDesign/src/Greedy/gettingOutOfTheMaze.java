package Greedy;

import java.io.*;
import java.util.*;

class gettingOutOfTheMaze {
    static class Node {

        List<Node> outgoingEdges;

        boolean marked;

        public Node() {
            this.outgoingEdges = new ArrayList<>();
            this.marked = false;
        }
    }

    static class Solution {

        // Implement the solve method to return the answer to the problem posed by the inputstream.
        public static String run(InputStream in) {
            return new Solution().solve(in);
        }

        public String solve(InputStream in) {
            Scanner sc = new Scanner(in);
            /* Read the first line */
            int n = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            int t = sc.nextInt();
            /* Create the nodes */
            Map<Integer, Node> nodes = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                nodes.put(i, new Node());
            }
            for (int i = 1; i <= m; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                sc.nextInt();
                nodes.get(from).outgoingEdges.add(nodes.get(to));
            }
            sc.close();

            Queue<Node> q = new LinkedList<>();

            nodes.get(s).marked = true;
            q.add(nodes.get(s));

            while (!q.isEmpty()) {
                Node node = q.remove();
                if (node == nodes.get(t)) {

                    return "yes";
                }
                for (Node to : node.outgoingEdges) {

                    if (!to.marked) {
                        to.marked = true;
                        q.add(to);
                    }
                }
            }

            return "no";
        }
    }
}