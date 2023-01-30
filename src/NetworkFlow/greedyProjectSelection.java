package NetworkFlow;

import javax.print.attribute.SetOfIntegerSyntax;
import java.util.*;

public class greedyProjectSelection {

    /**
     * You should implement the method below.
     *
     * @param n            The number of projects
     * @param benefits     An array of dimension n+1 containing the benefits of all the projects for 1 <= i <= n
     * @param costs        An array of dimension n+1 containing the costs of all the projects for 1 <= i <= n
     * @param dependencies is an array of dimension (n+1)*(n+1) that contains value 1 iff project i depends on j and 0 otherwise, for all 1 <= i,j <= n.
     * @return the set of project ids that are selected. Note that the ids of `Node`s in the graph correspond to the ids of the projects they represent.
     */
    public static Set<Integer> outputSelection(int n, int[] benefits, int[] costs, int[][] dependencies) {
        Graph g = buildGraph(n, benefits, costs, dependencies);
        MaxFlow.maximizeFlow(g);
        return bfs(g);
    }

    public static Set<Integer> bfs(Graph g) {
        Queue<Node> q = new LinkedList<>();
        q.add(g.getSource());
        Set<Integer> ret = new HashSet<>();
        while(!q.isEmpty()) {
            Node currNode = q.poll();
            for(Edge e : currNode.getEdges()) {
                if(e.getResidual() > 0 && !ret.contains(e.to.getId()) &&  e.to != g.getSource()) {
                    q.add(e.to);
                    ret.add(e.to.getId());
                }
            }
        }
        return  ret;
    }

    private static Graph buildGraph(int n, int[] benefits, int[] costs, int[][] dependencies) {
        Node source = new Node(0);
        Node sink = new Node(n + 1);
        ArrayList<Node> nodes = new ArrayList<>(n + 2);
        nodes.add(source);
        for (int i = 1; i <= n; i++) {
            Node newNode = new Node(i);
            nodes.add(newNode);
        }
        nodes.add(sink);
        for (int i = 1; i <= n; i++) {
            source.addEdge(nodes.get(i), benefits[i]);
            nodes.get(i).addEdge(sink, costs[i]);
            for (int j = 1; j <= n; j++) {
                if (dependencies[i][j] > 0) {
                    nodes.get(i).addEdge(nodes.get(j), Integer.MAX_VALUE / 2);
                }
            }
        }
        return new Graph(nodes, source, sink);
    }

}
