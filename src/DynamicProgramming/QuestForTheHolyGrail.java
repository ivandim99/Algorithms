package DynamicProgramming;


import java.util.Objects;
import java.util.Set;

public class QuestForTheHolyGrail {

    /**
     * You should implement this method.
     *
     * @param n the number of nodes.
     * @param m the number of edges.
     * @param g the index of the holy grail in V.
     * @param V a list of Nodes, where V[1] is the current state and V[g] is the holy grail. You should not use V[0].
     * @param E a set of Edges
     * @return The length of the shortest path that uses the research team at most once.
     */
    public static double solve(int n, int m, int g, Node[] V, Set<Edge> E) {
        double[][] mem = new double[n+1][2]; //because from and to
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j < 2;j++) {
                mem[i][j] = Integer.MAX_VALUE;
            }
        }

        mem[1][1] = mem[1][0] = 0; //start is 0
        for (int counter = 1; counter <= n; counter++) {
            for (int i = 1; i <= n; i++) {
                double[] minEdges = new double[2];
                minEdges[0] = minEdges[1] = Integer.MAX_VALUE;
                for (Edge e : E) {
                    if (e.to.getId() == i) {
                        minEdges[0] = Math.min(minEdges[0], e.cost + mem[e.from.getId()][0]);
                        minEdges[1] = Math.min(minEdges[1], Math.min(mem[e.from.getId()][0] + e.cost * 0.5, mem[e.from.getId()][1] + e.cost));
                    }
                }
                mem[i][0] = Math.min(mem[i][0], minEdges[0]);
                mem[i][1] = Math.min(mem[i][1], minEdges[1]);
            }
        }

        if(mem[g][1] == Integer.MAX_VALUE) {
            return -1;
        }

        return mem[g][1];
    }

}

class Node {

    protected int id;

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean equals(Object other) {
        if (other instanceof Node) {
            Node that = (Node) other;
            return this.id == that.id;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class Edge {

    protected int cost;

    protected Node from;

    protected Node to;

    protected Edge(Node from, Node to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public Node getFrom() {
        return from;
    }

    public Node getTo() {
        return to;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Edge edge = (Edge) o;
        return cost == edge.cost && Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, from, to);
    }
}