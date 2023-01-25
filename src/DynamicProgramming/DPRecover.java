package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class DPRecover {

    /**
     * You should implement this method.
     *
     * @param n the number of items n.
     * @param m the maximum weight.
     * @param v the array containing the weights of the items, in index 1 through n. Note this means
     *     you should ignore v[0] and use v[1] through v[n].
     * @param mem the memory filled by the dynamic programming algorithm using the provided
     *     recursive formulation.
     * @return the set of indices of items that together form the optimal solution.
     */
    public static Set<Integer> solve(int n, int m, int[] v, int[][] mem) {
        int x = n;
        int y = 0;
        Set<Integer> ret = new HashSet<>();

        while(x > 0) {
            if(v[x] <= m - y && mem[x][y] == v[x] * mem[x - 1][y + v[x]]) {
                ret.add(x);
                y += v[x];
                x -= 1;
            } else {
                x -= 1;
            }
        }
        return ret;
    }

}
