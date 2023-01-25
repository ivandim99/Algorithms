package DynamicProgramming;

public class FishSalesman {

    /**
     * @param n the number of days
     * @param P the profits that can be made on day 1 through n on location P are stored in P[1]
     *     through P[n].
     * @param Q the profits that can be made on day 1 through n on location Q are stored in Q[1]
     *     through Q[n].
     * @return the maximum obtainable profit.
     */
    public static int solve(int n, int[] P, int[] Q) {
        int[][] mem = new int[2][n + 1];
        // TODO return 0

        /*
        //
        // Come up with an iterative dynamic programming solution to the salesman problem.
        // TODO mem[0][0] = ...; // Base case
        // TODO mem[1][0] = ...;
        // TODO mem[0][1] = ...;
        // TODO mem[1][1] = ...;
        */
        // Some for loop to fill the rest of the memory


        mem[0][0] = Integer.MIN_VALUE;
        mem[1][0] = Integer.MIN_VALUE;

        mem[0][1] = P[1];
        mem[1][1] = Q[1];

        for(int i = 2; i <= n; i++) {
            mem[0][i] = Math.max(P[i] + mem[0][i - 1],mem[1][i - 1]);
            mem[1][i] = Math.max(Q[i] + mem[1][i - 1],mem[0][i - 1]);
        }

        return Math.max(mem[0][n],mem[1][n]);
    }

}
