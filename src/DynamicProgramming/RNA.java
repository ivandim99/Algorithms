package DynamicProgramming;

public class RNA {

    /**
     * You should implement this method.
     *
     * @param n the number of bases.
     * @param b an array of size n+1, containing the bases b_1 through b_n. Note that you should use b[1] through b[n]
     * @param p an array of size n+1 by n+1, containing the validity for pair (i,j). A pair (i,j) is valid iff p[i][j] == true. Note that you should use p[1][1] through p[n][n].
     * @return The size of the largest set of base pairs.
     */
    public static int solve(int n, char[] b, boolean[][] p) {
        int[][] mem = new int[n + 1][n + 1];
        for(int k = 1; k <= n;k++) {
            for(int i = 1;i <= n - k;i++) {
                int j = i + k;

                if(i >= j - 4 || i > j || i == 0 || j == 0)
                    mem[i][j] = 0;

                else {
                    mem[i][j] = mem[i][j-1];
                    for(int t = i; t <= j - 4;t++) {
                        if (p[i][j])
                            mem[i][j] = Math.max(mem[i][j], 1 + mem[i][t-1] + mem[t+1][j-1]);
                    }
                }
            }
        }
        return mem[1][n];
    }

}
