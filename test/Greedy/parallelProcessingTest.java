package Greedy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class parallelProcessingTest {
    @Test
    public void example() {
        int n = 5;
        int m = 2;
        int[] deadlines = {0, 3, 1, 1, 1, 2};
        Assertions.assertEquals(1, parallelProcessing.solve(n, m, deadlines));
    }
}