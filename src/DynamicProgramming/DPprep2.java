package DynamicProgramming;

public class DPprep2 {

    /**
     * You should implement this method.
     *
     * @param t the number of days we receive patients for.
     * @param p the number of patients per day from index _1_ to _n_, you should ignore p[0].
     * @param c the cost of a new shipment of vaccines, regardless of how many you order.
     * @param f the cost _per_ vaccines stored overnight.
     * @param s the maximum number of vaccines we can store overnight.
     * @return the minimal cost to vaccinate all patients.
     */
    public static int minimiseCosts(int t, int[] p, int c, int f, int s) {
        int[][] mem = new int[t + 2][s + 1];
        for(int i = t + 1; i >= 0; i--) {
            for(int j = 0; j <= s; j++) {
                if(i == t + 1 && j == 0) {
                    mem[i][j] = 0;
                }
                if(i == t + 1 && j > 0) {
                    mem[i][j] = Integer.MAX_VALUE;
                }
                if(p[i] <= j) {
                    mem[i][j] = mem[i + 1][j - p[i]] + f * (j - p[i]);
                }
                else {
                    //TODO
                }
            }
        }
        return mem[0][0];
    }

}
