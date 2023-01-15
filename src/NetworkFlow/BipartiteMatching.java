package NetworkFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BipartiteMatching {

    /**
     * You should implement this method
     *
     * @param n the number of nodes in X and Y (i.e. n = |X| = |Y|)
     * @param connections set of connections between one object from X and one object from Y.
     *     Objects in X and Y are labelled 1 <= label <= n
     * @return the size of the maximum matching
     */
    public static int maximumMatching(int n, Set<Connection> connections) {
        List<Node> nodes = new ArrayList<>();
        Node source = new Node(-1, 0);
        Node sink = new Node(-2, 0);
        nodes.add(source);
        nodes.add(sink);
        Node[] xs = new Node[n + 1];
        Node[] ys = new Node[n + 1];
        // TODO

        for(int i = 1 ;i <= n; i++) {
            xs[i] = new Node(i);
            ys[i] = new Node(i);
            source.addEdge(xs[i],1);
            ys[i].addEdge(sink,1);
            nodes.add(xs[i]);
            nodes.add(ys[i]);
        }
        for(Connection connection: connections) {
            xs[connection.x].addEdge(ys[connection.y],1);
        }

        // Create one node for every object in X, and every object in Y.
        // We recommend we put them in xs and ys for easy reference, but make sure to also put them
        // in nodes!
        for (Node node : nodes) {
            System.out.println(node.getId());
        }
        Graph g = new Graph(nodes, source, sink);
        return MaxFlow.maximizeFlow(g);
    }

}
