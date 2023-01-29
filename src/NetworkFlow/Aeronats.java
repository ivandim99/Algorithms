package NetworkFlow;

import java.util.ArrayList;
import java.util.List;

public class Aeronats {

    /**
     * @param l          the number of flights Lee has already done
     * @param n          the number of competitors
     * @param m          the number of open slots left
     * @param flights    the number of flights each of the competitors has done. You should use flights[1] to flights[n]
     * @param compatible 2D boolean array such that slot i can be used by competitor j iff compatible[i][j] is true. Note that compatible[0][x] and compatible[x][0] should not be used.
     * @return
     */
    public static boolean solve(int l, int n, int m, int[] flights, boolean[][] compatible) {
        List<Node> nodes = new ArrayList<>();
        Node source = new Node(-1,0);
        Node sink = new Node(-2,0);
        nodes.add(source);
        nodes.add(sink);

        Node[] slots = new Node[m+1];
        Node[] competitors = new Node[n+1];

        for(int i = 1; i <= m; i++) {
            nodes.add(slots[i]);
            source.addEdge(slots[i],0,1);
        }

        for(int i = 1; i <= n; i++) {
            nodes.add(competitors[i]);
            competitors[i].addEdge(sink,0,l - flights[i] - 1);
        }

        for(int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(compatible[i][j])
                    slots[i].addEdge(competitors[j],0,1);
            }
        }

        Graph g = new Graph(nodes,source,sink);

        return MaxFlow.maximizeFlow(g) == m;
    }

}
