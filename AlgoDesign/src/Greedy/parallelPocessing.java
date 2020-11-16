package Greedy;

import java.util.*;

public class parallelPocessing {


    static class Solution {

        public static /**
         * @param n the number of jobs
         * @param m the number of processors
         * @param deadlines the deadlines of the jobs 1 through n. NB: you should ignore deadlines[0]
         * @return the minimised maximum lateness.
         */
        int solve(int n, int m, int[] deadlines) {
            Arrays.sort(deadlines);

            int max_lateness = Integer.MIN_VALUE;
            int k = 1;  //time

            for(int i = 1;i <= m;i++) {
                for(int j = i;j <= n;j += m) {

                    if(max_lateness < Math.max(0,(k - deadlines[j]))) {
                        max_lateness = Math.max(0,(k - deadlines[j]));
                    }

                    k++;
                }
                k=1;
            }

            return max_lateness;
        }
    }


}
