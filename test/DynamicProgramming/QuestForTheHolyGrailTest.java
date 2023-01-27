package DynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class QuestForTheHolyGrailTest {

    @Test
    public void example_one_edge() {
        int n = 2;
        int m = 1;
        int g = 2;
        Node[] V = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            V[i] = new Node(i);
        }
        Set<Edge> E = new HashSet<>();
        E.add(new Edge(V[1], V[2], 8));
        /* Only one edge to go, so might as well use the team!
         * Costs are therefore 8/2 = 4.
         */
        Assertions.assertEquals(4, QuestForTheHolyGrail.solve(n, m, g, V, E), 1e-4);
    }

    @Test
    public void example_two_edges() {
        int n = 3;
        int m = 2;
        int g = 3;
        Node[] V = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            V[i] = new Node(i);
        }
        Set<Edge> E = new HashSet<>();
        E.add(new Edge(V[1], V[2], 8));
        E.add(new Edge(V[2], V[3], 3));
        /* Only two edge to go, so use it on the most expensive one.
         * Costs are therefore 8/2 + 3 = 7.
         */
        Assertions.assertEquals(7, QuestForTheHolyGrail.solve(n, m, g, V, E), 1e-4);
    }

    @Test
    public void example_two_paths() {
        int n = 4;
        int m = 4;
        int g = 3;
        Node[] V = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            V[i] = new Node(i);
        }
        Set<Edge> E = new HashSet<>();
        E.add(new Edge(V[1], V[2], 8));
        E.add(new Edge(V[2], V[3], 3));
        E.add(new Edge(V[1], V[4], 3));
        E.add(new Edge(V[4], V[3], 6));
        /* Two paths to chose from, best option is 3 + 6/2
         */
        Assertions.assertEquals(6, QuestForTheHolyGrail.solve(n, m, g, V, E), 1e-4);
    }

}