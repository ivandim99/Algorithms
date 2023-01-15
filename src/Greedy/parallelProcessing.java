package Greedy;

import java.util.Arrays;

public class parallelProcessing {

    /**
     * @param n the number of jobs
     * @param m the number of processors
     * @param deadlines the deadlines of the jobs 1 through n. NB: you should ignore deadlines[0]
     * @return the minimised maximum lateness.
     */
    public static int solve(int n, int m, int[] deadlines) {
        Arrays.sort(deadlines);

        int maxLateness = 0;
        for(int i = 1; i <= m;i++) {
            int flow = 0;
            for (int j = 1; j <= n; j+=m) {
                flow ++;
                int currLate = flow - deadlines[j];
                if(currLate > maxLateness) {
                    maxLateness = currLate;
                }
            }
        }
        return maxLateness;
    }

}
