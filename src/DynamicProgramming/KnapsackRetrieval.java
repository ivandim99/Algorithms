package DynamicProgramming;

import java.util.LinkedList;
import java.util.List;

public class KnapsackRetrieval {

    /**
     * Retrieves the knapsack items used in an optimal solution.
     *
     * @param n the number of items.
     * @param W the maximum weight.
     * @param w the weight of the items, indexed w[1] to w[n].
     * @param v the value of the items, indexed v[1] to v[n].
     * @param mem is a (n x W) integer array, where element mem[i][j] is the maximum value using
     *     only elements 1 to i and max weight of j.
     * @return list containing the id of the items used in the optimal solution, ordered
     *     increasingly.
     */
    public static List<Integer> mathijsFavouriteProblem(
            int n, int W, int[] w, int[] v, int[][] mem) {
        LinkedList<Integer> ret = new LinkedList<>();
        int currW = W;
        for(int currN = n; currN > 0;currN--) {
            int currValue = mem[currN][currW];
            if(currW >= w[currN] && currValue == v[currN] + mem[currN - 1][currW - w[currN]]) {
                currW -= w[currN];
                ret.addFirst(currN);
            }
        }
        return ret;
    }

}
