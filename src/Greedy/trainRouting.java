package Greedy;

import java.util.*;

class Node {

    List<Node> outgoingEdges;

    int id;

    boolean marked;

    public Node(int id) {
        this.outgoingEdges = new ArrayList<>();
        this.id = id;
    }

}

class Edge {

    int from, to;

    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Edge edge = (Edge) o;
        return from == edge.from && to == edge.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}

class trainRouting {

    /**
     * @param n the number of nodes
     * @param m the number of edges
     * @param edges the set of edges, with endpoints labelled between 1 and n inclusive.
     * @return true iff there is a cycle in the graph
     */
    public static boolean isThereACycle(int n, int m, Set<Edge> edges) {
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            nodes.put(i, new Node(i));
        }
        for (Edge e : edges) {
            nodes.get(e.from).outgoingEdges.add(nodes.get(e.to));
        }
        for (int i = 1; i <= n; i++) {
            if (dfsCycleI(nodes.get(i))) {
                return true;
            }
        }
        return false;
    }

    public static boolean dfsCycleI(Node node) {
        Stack<Node> stack = new Stack<>();
        Set<Node> visited = new HashSet<>();
        for (Node n : node.outgoingEdges) {
            stack.push(n);
            visited.add(n);
        }
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            if (curr == node) {
                return true;
            }
            for (Node n : curr.outgoingEdges) {
                if (!visited.contains(n)) {
                    stack.push(n);
                    visited.add(n);
                }
            }
        }
        return false;
    }
}