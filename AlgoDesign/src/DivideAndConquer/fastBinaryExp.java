package DivideAndConquer;

public class fastBinaryExp {
    /**
     * Computes the matrix C, containing the values for a^b, for all values in a and b.
     *
     * @param a array containing the bases
     * @param b array containing the exponents
     * @return matrix C
     */
    public static int[][] computeC(int[] a, int[] b) {
        int[][] ret = new int[a.length][b.length];
        for(int i = 0;i < a.length;i++) {
            for(int j = 0;j < b.length;j++) {
                ret[i][j] = ComputeExponent(a[i],b[j]);
            }
        }
        return ret;
    }

    public static int ComputeExponent(int num , int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent % 2 == 0) {
            return ComputeExponent(num, exponent / 2) * ComputeExponent(num, exponent / 2);
        } else {
            return num * ComputeExponent(num, exponent - 1);
        }
    }
}