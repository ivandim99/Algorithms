package DynamicProgramming;

public class choosingBetweenWork {

    /**
     * Come up with an iterative dynamic programming solution to the weighted interval scheduling
     * problem. NB: You may assume the jobs are sorted by ascending finishing time.
     *
     * @param n the number of jobs
     * @param s the start times of the jobs for jobs 1 through n. Note that s[0] should be ignored.
     * @param f the finish times of the jobs for jobs 1 through n. Note that f[0] should be ignored.
     * @param v the values of the jobs for jobs 1 through n. Note that v[0] should be ignored.
     * @param p the predecessors of the jobs for jobs 1 through n. Note that p[0] should be ignored
     *     and that -1 represents there being no predecessor.
     * @return the weight of the maximum weight schedule.
     */
    public static int solve(int n, int[] s, int[] f, int[] v, int[] p) {
        int[] mem = new int[n + 1];
        // TODO mem[0] = ...; // Base case
        mem[0] = 0;
        // Either skip this job and get mem[j-1]
        // or include this job and get the optimal value for the previous compatible job.
        for (int j = 1; j <= n; j++) {
            // TODO mem[j] = ...;
            mem[j] = Math.max(mem[j - 1],v[j] + mem[p[j]]);
        }
        // TODO

        // Returning the obtained value at index n.
        return mem[n];
    }

}
