package NetworkFlow;

import java.util.*;

public class FordFulkerson {

    private static List<Edge> findPath(Graph g, Node start, Node end) {
        Map<Node, Edge> mapPath = new HashMap<Node, Edge>();
        Queue<Node> sQueue = new LinkedList<Node>();
        Node currentNode = start;
        sQueue.add(currentNode);

        // BFS: loop until there are no nodes to explore, or we have found a path.
        while (!sQueue.isEmpty() && currentNode != end) {
            currentNode = sQueue.remove();
            for (Edge e : currentNode.getEdges()) {
                Node to = e.getTo();
                // Only consider th edge if:
                // 1) The neighbour is not the start
                // 2) We do not yet have a path to the neighbour.
                // 3) We can travel via this edge, i.e. the residual capacity is larger than 0.
                if (to != start && mapPath.get(to) == null && e.getResidual() > 0) {
                    sQueue.add(e.getTo());
                    mapPath.put(to, e);
                }
            }
        }
        if (sQueue.isEmpty() && currentNode != end)
            return null;
        LinkedList<Edge> path = new LinkedList<Edge>();
        Node current = end;

        // Reconstruct the path from the map. Till when do we continue?
        while (mapPath.get(current) != null) {
            Edge e = mapPath.get(current);
            path.addFirst(e);
            current = e.getFrom();
        }
        return path;

    }

    public static int maximizeFlow(Graph g) {
        int f = 0;
        Node sink = g.getSink();
        Node source = g.getSource();
        List<Edge> path;
        while ((path = findPath(g, source, sink)) != null) {
            int r = Integer.MAX_VALUE;

            // Find the bottleneck.
            for (Edge e : path) {
                r = Math.min(r,e.getResidual());
            }

            // Augment the flow along these edges.
            for (Edge e : path) {
                e.augmentFlow(r);
            }
            f += r;
        }
        return f;
    }

}
