package Greedy;

public class packingTrucks {


    class Solution {

        public  /**
         * @param n the number of packages
         * @param weights the weights of all packages 1 through n. Note that weights[0] should be ignored!
         * @param maxWeight the maximum weight a truck can carry
         * @return the minimal number of trucks required to ship the packages _in the given order_.
         */
        int minAmountOfTrucks(int n, int[] weights, int maxWeight) {
            int trucks = 0;
            int w = 0;
            if(n > 0) {
                trucks++;
                w = weights[1];
            }
            for(int i = 2;i <= n;i++) {

                if(w + weights[i] <= maxWeight) {
                    w += weights[i];
                }
                else {
                    trucks++;
                    w = weights[i];
                }
            }
            return trucks;
        }
    }


}
