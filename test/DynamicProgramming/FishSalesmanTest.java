package DynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FishSalesmanTest {

    @Test
    public void example() {
        int n = 5;
        int[] P = {0, 80, 30, 30, 70, 80};
        int[] Q = {0, 90, 60, 60, 50, 20};
        Assertions.assertEquals(300, FishSalesman.solve(n, P, Q));
    }

}