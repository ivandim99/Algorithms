package NetworkFlow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

class BipartiteMatchingTest {

    @Test()
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
        Assertions.assertEquals(3, BipartiteMatching.maximumMatching(n, connections));
    }

    @Test()
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
        Assertions.assertEquals(2, BipartiteMatching.maximumMatching(n, connections));
    }

}