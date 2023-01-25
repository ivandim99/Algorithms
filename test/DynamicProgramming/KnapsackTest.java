package DynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {

    @Test
    void test() {
        int W = 22;
        int n = 10;
        int[] w = {0,4,5,3,8,5,7,9,3,2,5};
        int[] v = {0,8,3,5,9,4,5,2,7,1,10};
        assertEquals(1,Knapsack.mathijsFavouriteProblem(n,W,w,v));
    }

}