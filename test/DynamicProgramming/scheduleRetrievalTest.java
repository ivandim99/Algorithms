package DynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class scheduleRetrievalTest {

    @Test
    public void example() {
        int[] s = { 0, 0, 1, 3 };
        int[] f = { 0, 3, 4, 8 };
        int[] v = { 0, 3, 5, 7 };
        int[] p = { 0, -1, -1, 1 };
        int[] mem = { 0, 3, 5, 10 };
        LinkedList<Integer> expected = new LinkedList<>();
        expected.add(1);
        expected.add(3);
        Assertions.assertEquals(expected, scheduleRetrieval.solve(3, s, f, v, p, mem));
    }

}