package DynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class independentSetGraphTest {
    @Test
    public void example() {
        int n = 5;
        int[] nodes = {0, 2, 1, 6, 8, 9};
        Assertions.assertEquals(17, independentSetGraph.weight(n, nodes));
    }

    @Test
    public void example_not_the_largest_set() {
        int n = 5;
        int[] nodes = {0, 2, 10, 6, 18, 9};
        Assertions.assertEquals(28, independentSetGraph.weight(n, nodes));
    }

    @Test
    public void example_not_just_alternating() {
        int n = 5;
        int[] nodes = {0, 200, 10, 6, 1800, 9};
        Assertions.assertEquals(2000, independentSetGraph.weight(n, nodes));
    }
}