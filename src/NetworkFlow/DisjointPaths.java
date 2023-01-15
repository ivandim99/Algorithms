package NetworkFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class DisjointPaths {

    /**
     * You should implement this method
     *
     * @param n the number of nodes.
     * @param sourceId the id (index) of the source node (1 <= sourceId <= n)
     * @param sinkId the id (index) of the sink node (1 <= sinkId <= n)
     * @param connections set of connections between one object from X and one object from Y.
     *     Objects in X and Y are labelled 1 <= label <= n
     * @return the maximum number of disjoint paths
     */
    public static int disjointPaths(int n, int sourceId, int sinkId, Set<Connection> connections) {
        List<Node> nodesList = new ArrayList<>();
        Node source, sink;
        // Creating flow graph from model
        Node[] nodes = new Node[n + 1];
        // Add all nodes
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
            nodesList.add(nodes[i]);
        }
        // Source & sink
        source = nodes[sourceId];
        sink = nodes[sinkId];
        // TODO Model the connections in the network flow graph.

        for(Connection connection : connections) {
            nodes[connection.x].addEdge(nodes[connection.y],1);
        }

        Graph g = new Graph(nodesList, source, sink);
        // TODO return answer

        return MaxFlow.maximizeFlow(g);

    }

}
