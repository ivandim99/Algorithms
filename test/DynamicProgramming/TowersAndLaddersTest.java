package DynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TowersAndLaddersTest {

    @Test
    public void example() {
        int n = 2;
        int m = 3;
        int[][] graph = {{3, 5, 6}, {4, 2, 1}};
        Assertions.assertEquals(1, TowersAndLadders.solve(n, m, graph));
    }

}