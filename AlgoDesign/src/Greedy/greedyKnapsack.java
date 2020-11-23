package Greedy;

import java.util.Arrays;

public class greedyKnapsack {

    static  class Solution {

        /**
         * Return the minimum number of items we need to get to the weight we want to get to.
         * @param n the number of item categories
         * @param w the weight we want to achieve with as few items as possible.
         * @param num the number of items in each category c_1 through c_n stored in num[1] through num[n] (NOTE: you should ignore num[0]!)
         * @param weight the weight of items in each category c_1 through c_n stored in weight[1] through weight[n] (NOTE: you should ignore weight[0]!)
         * @return minimum number of items needed to get to the required weight
         */
        public static int run(int n, int w, int[] num, int[] weight) {
            return new Solution().solve(n, w, num, weight);
        }

        public int solve(int n, int w, int[] num, int[] weight) {
            Arrays.sort(weight);
            int count = 0;
            int carry = 0;
            for(int i = n;i > 0;i--) {
                if(carry + weight[i] <= w) {
                    carry += weight[i];
                    count ++;
                    i++;
                }
            }
            return count;
        }
    }


}
