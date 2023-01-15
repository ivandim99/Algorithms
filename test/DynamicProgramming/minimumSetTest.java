package DynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class minimumSetTest {

    @Test
    public void example() {
        int n = 7;
        int[] nodes = {0, 1, 18, 18, 1, 18, 18, 1};
        Assertions.assertEquals(3, minimumSet.solve(n, nodes));
    }

}