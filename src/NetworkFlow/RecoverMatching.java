package NetworkFlow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RecoverMatching {

    /**
     * Recovers the solution for maximum matches.
     *
     * @param n           the number of nodes in X and Y (i.e. n = |X| = |Y|)
     * @param connections set of connections between one object from X and one object from Y.
     *                    Objects in X and Y are labelled 1 <= label <= n
     * @return solution to the maximum matches problem
     */
    public static Set<Match> recoverSolution(int n, Set<Connection> connections) {
        Graph graph = maximumMatching(n, connections);
        MaxFlow.maximizeFlow(graph);
        return recoverMatches(graph);
    }

    public static
    /**
     * Recovers the matches from a 1-1 bipartite matching problem
     *
     * @param graph the graph on which maximum matching algorithm was applied
     * @return a set of matches recovered
     */
    Set<Match> recoverMatches(Graph graph) {
        Set<Match> ret = new HashSet<>();
        for (Edge edge : graph.getSource().getEdges()) {
            if(edge.flow == 1) {
                Node x = edge.to;
                for (Edge xEdge : x.getEdges()) {
                    if (xEdge.flow == 1 && xEdge.to != graph.getSource())
                        ret.add(new Match(x.id, xEdge.to.id));
                }
            }
    }
        return ret;
}

    /**
     * Construct network flow graph from the set of connections
     *
     * @param n           the number of nodes in X and Y (i.e. n = |X| = |Y|)
     * @param connections set of connections between one object from X and one object from Y.
     *                    Objects in X and Y are labelled 1 <= label <= n
     * @return graph representing the connections
     */
    public static Graph maximumMatching(int n, Set<Connection> connections) {
        List<Node> nodes = new ArrayList<>();
        Node source = new Node(-1, 0);
        Node sink = new Node(-2, 0);
        nodes.add(source);
        nodes.add(sink);
        Node[] xs = new Node[n + 1];
        Node[] ys = new Node[n + 1];
        // Create one node for every object in X, and every object in Y.
        // We recommend we put them in xs and ys for easy reference, but make sure to also put them
        // in nodes!
        for (int i = 1; i <= n; i++) {
            xs[i] = new Node(i);
            ys[i] = new Node(i);
            source.addEdge(xs[i], 1);
            ys[i].addEdge(sink, 1);
            nodes.add(xs[i]);
            nodes.add(ys[i]);
        }
        for (Connection con : connections) {
            xs[con.x].addEdge(ys[con.y], 1);
        }
        Graph g = new Graph(nodes, source, sink);
        return g;
    }

}
