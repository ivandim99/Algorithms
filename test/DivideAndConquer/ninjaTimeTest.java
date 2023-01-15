package DivideAndConquer;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ninjaTimeTest {

    // see assignment text
    @Test
    public void text_example_dc() {
        int n = 4;
        int[] h = { 0, 5, 10, 12, 10 };
        assertEquals(7, ninjaTime.findBestTrainingDivideAndConquer(n, h));
    }

    // [1,4] gets you 4-1 = 3
    // [1,4,3] gets you (4-1) + -(1)^2 = 2
    // [4,3] gets you -(1)^2 = -1
    // [] gets you 0
    // So 3 is the best
    @Test
    public void small_example_dc() {
        int n = 3;
        int[] h = { 0, 1, 4, 3 };
        assertEquals(3, ninjaTime.findBestTrainingDivideAndConquer(n, h));
    }

    // The best one is [5,10,12,11,13]
    @Test
    public void large_example_dc() {
        int n = 8;
        int[] h = { 0, 6, 5, 10, 12, 11, 13, 10, 2 };
        assertEquals(8, ninjaTime.findBestTrainingDivideAndConquer(n, h));
    }

}