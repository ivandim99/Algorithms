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
        for (int i = t + 1; i >= 0; i--) {
            for (int j = 0; j <= s; j++) {
                if (i == t + 1 && j == 0) {
                    mem[i][j] = 0;
                } else if (i == t + 1 && j > 0) {
                    mem[i][j] = Integer.MAX_VALUE / 2;
                } else if (j >= p[i]) {
                    mem[i][j] = mem[i + 1][j - p[i]] + f * (j - p[i]);
                } else {
                    //here we are going back from i at max to 0 so we want to see and the else statement we are in
                    //currently we assume we don not have enough vaccines for the patients of the current day
                    //so we want to get the min cost of vaccines we need so we know what amount we need to buy
                    //we have a new total that needs to be at least the amount of patients of today and at most the max
                    //amount we can store + the number of patients
                    mem[i][j] = Integer.MAX_VALUE / 2;
                    for (int new_total = p[i]; new_total <= s + p[i]; new_total++) {
                        mem[i][j] =
                                Math.min(
                                        mem[i][j],
                                        mem[i + 1][new_total - p[i]] + c + f * (new_total - p[i]));
                    }
                }
            }
        }
        return mem[0][0];
    }

}
