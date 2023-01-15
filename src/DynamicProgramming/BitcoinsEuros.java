package DynamicProgramming;

public class BitcoinsEuros {

    /**
     * Implement this method
     *
     * @param t - the number of days you have
     * @param r - exchange rates of each day. Ignore index 0. I.e. the exchange rate of the first
     *     day can be found using r[1].
     * @return the maximum amount of euros after T days
     */
    public static double optimalTrade(int t, double[] r) {
        double[] btc = new double[r.length];
        double[] euros = new double[r.length];

        btc[0] = 0.1;
        euros[0] = 0;

        for(int i = 1;i <= t;i++) {
            btc[i] = Math.max(btc[i - 1],(euros[i - 1] - 5) / r[i]);
            euros[i] = Math.max(euros[i - 1],(btc[i - 1] * 0.95 * r[i]));
        }
        return euros[t];
    }

}
