package DivideAndConquer;

public class fastBinaryExp {

     /**
     * Computes the matrix C, containing the values for a^b, for all values in a and b. Note that
     * you may not use math.pow but should implement your own fast binary exponentiation algorithm.
     *
     * @param a array containing the bases
     * @param b array containing the exponents
     * @return matrix C where entry (i,j) contains a_i^b_j
     */
    public static int[][] computeC(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[][] ret = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                ret[i][j] = exp(a[i],b[j]);
            }
        }
        return ret;
    }

    public static int exp(int number, int exponent) {
        if(exponent == 0) {
            return 1;
        }
        else if (exponent == 1) {
            return number;
        }
        else if (exponent % 2 == 0) {
            return exp(number,exponent / 2) * exp(number, exponent / 2);
        }
        else {
            return exp(number,exponent - 1) * number;
        }
    }
}