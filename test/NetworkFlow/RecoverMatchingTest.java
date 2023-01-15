package NetworkFlow;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class RecoverMatchingTest {

    @Test
    public void exampleThreeMatches() {
        int n = 3;
        Set<Connection> connections = new HashSet<>();
        /* 1 can be matched with 1, 2
          2 can be matched with 2, 3
          3 can be matched with 3
          So we can make a matching of size 3
        */
        connections.add(new Connection(1, 1));
        connections.add(new Connection(1, 2));
        connections.add(new Connection(2, 2));
        connections.add(new Connection(2, 3));
        connections.add(new Connection(3, 3));
        Assertions.assertTrue(
                isValidSolution(n, connections, RecoverMatching.recoverSolution(n, connections)));
    }

    @Test
    public void exampleTwoMatches() {
        int n = 3;
        Set<Connection> connections = new HashSet<>();
        /* 1 can be matched with 1, 2
          2 can be matched with 3
          3 can be matched with 3
          So we can make a matching of size 2
        */
        connections.add(new Connection(1, 1));
        connections.add(new Connection(1, 2));
        connections.add(new Connection(2, 3));
        connections.add(new Connection(3, 3));
        Assertions.assertTrue(
                isValidSolution(n, connections, RecoverMatching.recoverSolution(n, connections)));
    }

    public static boolean isValidSolution(int n, Set<Connection> connections, Set<Match> matches) {
        Graph graph = RecoverMatching.maximumMatching(n, connections);
        int maxFlow = MaxFlow.maximizeFlow(graph);
        if (matches.size() != maxFlow) return false;
        int[] x = new int[n + 1];
        int[] y = new int[n + 1];
        for (Match match : matches) {
            if (!connections.contains(new Connection(match.x, match.y))) return false;
            x[match.x]++;
            y[match.y]++;
        }
        for (int i = 1; i <= n; i++) if (x[i] > 1 || y[i] > 1) return false;
        return true;
    }
}