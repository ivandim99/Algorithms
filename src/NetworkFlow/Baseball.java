package NetworkFlow;

import java.util.ArrayList;

public class Baseball {

    /**
     * @param x the id of the team you are rooting for.
     * @param m the total number of teams (team ids are between 1 and m inclusive)
     * @param w the number of wins of each team already has in w[1] to w[m], you should ignore w[0].
     * @param toPlay the number of games team i and j still play against each other, e.g.
     *     toPlay[1][2] is the number of games 1 and two still play against each other. Note that
     *     this is symmetrical, i.e., toPlay[i][j] == toPlay[j][i].
     * @return true iff x can still be the team to have won the most games after all games have been
     *     played.
     */
    public static boolean solve(int x, int m, int[] w, int[][] toPlay) {
        int winsX = w[x];

        for (int i = 1; i <= m; i++) {
            winsX += toPlay[i][x];
        }

        ArrayList<Node> nodes = new ArrayList<>();
        Node source = new Node(0);
        Node sink = new Node(m + 1);
        nodes.add(source);
        nodes.add(sink);

        for (int i = 1; i <= m; i++) {
            nodes.add(new Node(i));
        }


        for (int i = 1; i <= m; i++) {
            if(i == x)
                continue;
            if(winsX < w[i])
                return false;

            nodes.get(i).addEdge(sink,winsX - w[i]);

            for(int j = i + 1; j <= m; j++) {
                if(j == x || toPlay[i][j] == 0) {
                    continue;
                }

                Node game = new Node(m);
                nodes.add(game);
                source.addEdge(game,toPlay[i][j]);
                game.addEdge(nodes.get(i),toPlay[i][j]);
                game.addEdge(nodes.get(j),toPlay[i][j]);
            }
        }

        Graph g = new Graph(nodes,source,sink);
        MaxFlow.maximizeFlow(g);

        for (Edge e : source.getEdges()) {
            if (e.getFlow() != e.getCapacity()) {
                return false;
            }
        }
        return true;
    }

}
