package DynamicProgramming;

import java.util.LinkedList;
import java.util.List;

public class scheduleRetrieval {

    /**
     * Using the memoized values from an iterative dynamic programming solution, retrieve the
     * schedule with the highest total weight. NB: You may assume the jobs are sorted by ascending
     * finishing time.
     *
     * @param n the number of jobs
     * @param s the start times of the jobs for jobs 1 through n. Note that s[0] should be ignored.
     * @param f the finish times of the jobs for jobs 1 through n. Note that f[0] should be ignored.
     * @param v the values of the jobs for jobs 1 through n. Note that v[0] should be ignored.
     * @param p the predecessors of the jobs for jobs 1 through n. Note that p[0] should be ignored
     *     and that -1 represents there being no predecessor.
     * @param mem where the ith element is the maximum weight of a schedule using the first i jobs.
     * @return list containing the id of the jobs used in the optimal schedule, ordered by ascending
     *     finishing time.
     */
    public static List<Integer> solve(int n, int[] s, int[] f, int[] v, int[] p, int[] mem) {
        int k = n;
        LinkedList<Integer> ret = new LinkedList<>();
        while(k > 0) {
            if(mem[k - 1] == mem[k]) {
                k--;
            }
            else {
                ret.addFirst(k);
                k = p[k];
            }
        }
        return ret;
    }
}
