package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class greedyBackpack {
    /**
     * Return the minimum number of items we need to get to the weight we want to get to.
     *
     * @param n      the number of item categories
     * @param w      the weight we want to achieve with as few items as possible.
     * @param num    the number of items in each category c_1 through c_n stored in num[1] through num[n] (NOTE: you should ignore num[0]!)
     * @param weight the weight of items in each category c_1 through c_n stored in weight[1] through weight[n] (NOTE: you should ignore weight[0]!)
     * @return minimum number of items needed to get to the required weight
     */
    public static int run(int n, int w, int[] num, int[] weight) {
        ArrayList<Weight> weights = new ArrayList<>();
        for(int i = 1; i <= n;i++) {
            weights.add(new Weight(num[i],weight[i]));
        }
        Collections.sort(weights);

        int res = 0;
        for(int i = 0 ; i  < n;i++) {
            int numOfWeights = Math.min(w / weights.get(i).w, weights.get(i).n);
            w -= numOfWeights * weights.get(i).w;
            res += numOfWeights;
        }
        return res;
    }

    static class Weight implements Comparable<Weight> {

        int n , w;

        public Weight(int n, int w) {
            this.n = n;
            this.w = w;
        }

        @Override
        public int compareTo(Weight o) {
            return - this.w + o.w;
        }
    }

}
