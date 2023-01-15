package DivideAndConquer;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class largestSumTest {

    @Test
    public void testExampleA() {
        int[] input = new int[] {2, -3, 2, 1};
        Assertions.assertEquals(3, largestSum.largestSum(input));
    }

    @Test
    public void testExampleB() {
        int[] input = new int[] {3, -3, -2, 42, -11, 2, 4, 4};
        Assertions.assertEquals(42, largestSum.largestSum(input));
    }

}