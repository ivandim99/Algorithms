package DynamicProgramming;

public class SequenceAlignment {


    public static int solve(String firstString, String secondString) {
        int n = firstString.length();
        int m = secondString.length();
        int[][] M = new int[n + 1][m + 1];
        for(int i = 1; i <= n; i++) {
            M[i][0] = i;
        }
        for(int i = 1; i <= m; i++) {
            M[0][i] = i;
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                int pay = 1;
                if(firstString.charAt(i - 1) == secondString.charAt(j - 1))
                    pay = 0;
                int left = M[i][j - 1] + 1;   //if we look to the left that means we insert
                int up = M[i - 1][j] + 1;     //if we look above we delete!
                int diagonal = M[i - 1][j - 1] + pay;   //if we look the diagonal we align
                M[i][j] = Math.min(Math.min(diagonal, left), up);
            }
        }

        return M[n][m];
    }

}
