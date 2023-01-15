package DynamicProgramming;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class intervalPredecessorsTest {

    @Test
    public void example() {
        int[] s = {0, 0, 1, 3};
        int[] f = {0, 3, 4, 8};
        int[] v = {0, 3, 5, 7};
        int[] p = {0, 0, 0, 1};
        int[] solution = intervalPredecessor.solve(3, s, f, v);
        solution[0] = 0;
        Assertions.assertArrayEquals(p, solution);
    }

}