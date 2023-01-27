package NetworkFlow;

import java.util.ArrayList;

public class ImageSegmentation {

    /**
     * @param n The number of pixels
     * @param m The number of connections
     * @param f The foreground values of the pixels in indices 1 to n inclusive.
     * @param b The background values of the pixels in indices 1 to n inclusive.
     * @param connected indicates what pixels are neighbours. connected[i][j] is true iff pixels i
     *     and j are neighbours.
     * @return the score of the segmentation.
     */
    public static int solve(int n, int m, int[] f, int[] b, boolean[][] connected) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node source = new Node(-1);
        Node sink = new Node(-2);
        nodes.add(source);
        nodes.add(sink);

        for(int i = 1; i <= n; i++) {
            Node node = new Node(i);
            nodes.add(node);
            source.addEdge(node,f[i]);
            node.addEdge(sink,b[i]);
        }

        for(int i = 1; i <= n; i++) {
            for(int j = i + 1 ; j <= n;j++) {
                if(connected[i][j]) {
                    nodes.get(i).addEdge(nodes.get(j),10);
                    nodes.get(j).addEdge(nodes.get(i),10);
                }
            }
        }

        Graph g = new Graph(nodes,source,sink);
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += f[i] + b[i];
        }
        return sum - MaxFlow.maximizeFlow(g);
    }

}
