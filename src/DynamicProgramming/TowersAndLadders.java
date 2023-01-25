package DynamicProgramming;

public class TowersAndLadders {

    public static int solve(int n, int m, int[][] graph) {
        return solveDP(n, m, graph);
    }

    public static int solveDP(int n, int m, int[][] graph) {
        /*
        //
        // Come up with an iterative dynamic programming solution to the ladder problem.
        // TODO mem[0] = ...; // Base case
        // TODO mem[i] = ...;
        */
        int[][] mem = new int[n][m];
        // TODO return 0;

        mem[0][0] = 0;

            for(int i = 1; i < n; i++) {
                for(int j = 1; j < m; j++) {
                    mem[i][j] = j - 1 < 0 ? mem[i][j] : Integer.max(mem[i][j - 1], graph[i][j] - graph[i][j - 1]);
                    mem[i][j] = i - 1 < 0 ? mem[i][j] : Integer.min(mem[i][j], Integer.max(mem[i - 1][j], graph[i][j] - graph[i - 1][j]));
                    mem[i][j] = j + 1 >= m ? mem[i][j] : Integer.min(mem[i][j], Integer.max(mem[i][j + 1], graph[i][j] - graph[i][j + 1]));
                    mem[i][j] = i + 1 >= n ? mem[i][j] : Integer.min(mem[i][j], Integer.max(mem[i + 1][j], graph[i][j] - graph[i + 1][j]));
            }
        }
            return mem[n - 1][m - 1];
    }

}
