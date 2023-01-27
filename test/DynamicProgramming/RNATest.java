package DynamicProgramming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RNATest {

    @Test
    public void example_no_compat() {
        int n = 8;
        char[] b = "\0AUCGAUCG".toCharArray();
        boolean[][] p = new boolean[n + 1][n + 1];
        p[1][3] = true;
        /* We can not combine any (due to the p values), so the largest set will have 0 elements.
         * Note that the 1-3 pairing doesn't work as 1 and 3 are less than 4 apart.
         */
        Assertions.assertEquals(0, RNA.solve(n, b, p));
    }

    @Test
    public void example_one_compat() {
        int n = 8;
        char[] b = "\0AUCGAUCG".toCharArray();
        boolean[][] p = new boolean[n + 1][n + 1];
        p[1][6] = true;
        /* We can only combine 1 with 6 which should get us a set of size 1.
         */
        Assertions.assertEquals(1, RNA.solve(n, b, p));
    }

}