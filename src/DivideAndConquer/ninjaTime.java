package DivideAndConquer;

public class ninjaTime {
    /**
     * Jump evaluation as given in the assignment description.
     * There should be no need to modify this function!
     */
    public static int evaluateJump(int height1, int height2) {
        if (height1 <= height2) {
            return height2 - height1;
        } else {
            int diff = height1 - height2;
            return -(diff * diff);
        }
    }

    /**
     * You should implement this method.
     *
     * @param n the number of trees
     * @param h the height of the trees h_1 through h_n. Note you should only use entries h[1] up to and including h[n].
     * @return the score of the best possible training.
     */
    public static int findBestTrainingDivideAndConquer(int n, int[] h) {
        return findBestTrainingDivideAndConquer(h,1,n);    // If there are no trees, the best training score is 0.

    }

    public static int findBestTrainingDivideAndConquer(int[] h,int low,int high) {
        if (low == high) {
            return 0;
        }

        if(low == high - 1) {
            return Math.max(0,evaluateJump(h[low],h[high]));
        }

        int mid = (low + high) / 2;

        int left = findBestTrainingDivideAndConquer(h,low,mid);
        int right = findBestTrainingDivideAndConquer(h,mid + 1,high);

        int temp = 0;
        int leftBest = 0;
        for(int i = mid - 1; i >= low;i--) {
            temp += evaluateJump(h[i],h[i+1]);
            if(temp > leftBest) {
                leftBest = temp;
            }
        }

        temp = 0;
        int rightBest = 0;
        for(int i = mid + 1; i <= high;i++) {
            temp += evaluateJump(h[i-1],h[i]);
            if(temp > rightBest) {
                rightBest = temp;
            }
        }

        int dcBest = Math.max(left,right);
        return Math.max(dcBest,leftBest + rightBest);
    }
}