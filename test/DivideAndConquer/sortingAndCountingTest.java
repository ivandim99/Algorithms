package DivideAndConquer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class sortingAndCountingTest {

    @Test
    public void countInversionsExample() {
        int[] input = {2, 1, 0, 8};
        Assertions.assertEquals(3, sortingAndCounting.countInversions(input));
    }

    @Test
    public void countInversionsExample2() {
        int[] input = {8, 3, 1, 2};
        Assertions.assertEquals(5, sortingAndCounting.countInversions(input));
        // All pairs except (1, 2) are inversions.
    }

}