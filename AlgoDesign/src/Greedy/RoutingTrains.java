package Greedy;

import java.io.*;
import java.util.*;

class RoutingTrains {
    static class Node {

        List<Node> outgoingEdges;

        boolean marked;

        public Node() {
            this.outgoingEdges = new ArrayList<>();
            this.marked = false;
        }
    }
    //it has a scanner reading from weblab's file
    static class Solution {

        // Implement the solve method to return the answer to the problem posed by the inputstream.
        public static String run(InputStream in) {
            return new Solution().solve(in);
        }

        public String solve(InputStream in) {
            Scanner sc = new Scanner(in);
            int n = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
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
            Node start = nodes.get(s);
            start.marked = true;
            q.add(start);
            while (!q.isEmpty()) {
                Node node = q.remove();
                for (Node edge : node.outgoingEdges) {
                    if (edge.marked) {
                        return "yes";
                    } else {
                        edge.marked = true;
                        q.add(edge);
                    }
                }
            }
            return "no";
        }
    }
}
