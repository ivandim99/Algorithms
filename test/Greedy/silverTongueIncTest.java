package Greedy;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class silverTongueIncTest {

    @Test
    public void example() {
        int n = 3;
        String[] s = {"", "Selling NFTs", "Producing math songs", "Visualising Turing Machines"};
        int[] d = {0, 2, 2, 3};
        int[] r = {0, 1, 2, 5};
        int[] c = {0, 8, 0, 1};
        Map<String, Integer> expectedAnswer = new HashMap<>();
        expectedAnswer.put("Visualising Turing Machines", 0);
        expectedAnswer.put("Producing math songs", 3);
        /**
         * Selling NFTs isn't worth doing at all, as the costs are higher than the revenue.
         * Visualising Turing Machines is worth it, and we do this first. Producing math songs are
         * worth it, and we do this second.
         */
        Map<String, Integer> theirAnswer = silverTongueInc.schedule(n, s, d, r, c);
        Assertions.assertEquals(expectedAnswer, theirAnswer);
    }

    @Test
    public void testTwoProfit() {
        int n = 3;
        String[] s = {"", "Selling NFTs", "Producing math songs", "Visualising Turing Machines"};
        int[] d = {0, 2, 2, 3};
        int[] r = {0, 1, 2, 5};
        int[] c = {0, 8, 0, 3};
        Map<String, Integer> expectedAnswer = new HashMap<>();
        expectedAnswer.put("Visualising Turing Machines", 0);
        expectedAnswer.put("Producing math songs", 3);
        /**
         * Selling NFTs isn't worth doing at all, as the costs are higher than the revenue.
         * Visualising Turing Machines is worth it, and we do this first. Producing math songs are
         * worth it, and we do this second.
         */
        Map<String, Integer> theirAnswer = silverTongueInc.schedule(n, s, d, r, c);
        Assertions.assertEquals(2, theirAnswer.size());
    }
}