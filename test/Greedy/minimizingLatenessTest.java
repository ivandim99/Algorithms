package Greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class minimizingLatenessTest {

    @Test
    public void example() {
        int n = 5;
        int[] t = {0, 1, 2, 1, 3, 1};
        int[] d = {0, 5, 1, 1, 1, 4};
        Assertions.assertEquals(5, minimizingLateness.solve(n, t, d));
    }

}