package DynamicProgramming;

public class Knapsack {

    /**
     * @param n the number of items
     * @param W the maximum weight
     * @param w the weight of the items, indexed w[1] to w[n].
     * @param v the value of the items, indexed v[1] to v[n];
     * @return the maximum obtainable value.
     */
    public static int mathijsFavouriteProblem(int n, int W, int[] w, int[] v) {
        Item[] items = new Item[n + 1];
        for(int i = 1;i <= n; i++) {
            items[i] = new Item(v[i],w[i]);
        }

        int[][] knapsack = new int[n + 1][W + 1];
        for(int i = 1; i <= n;i++) {
            for(int j = 1; j <= W;j++) {
                if(i==0 && j==0) {
                   knapsack[i][j] = 0;
                }
                if(items[i].weight > j) {
                    knapsack[i][j] = knapsack[i - 1][j];
                }
                else {
                    knapsack[i][j] = Math.max(items[i].value + knapsack[i - 1][j - items[i].weight],knapsack[i - 1][j]);
                }
            }
        }
        return knapsack[n][W];
    }

    public static class Item {
        int value,weight;

        public Item(int value,int weight) {
            this.value = value;
            this.weight = weight;
        }
    }

}
