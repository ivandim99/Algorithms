package DivideAndConquer;

public class largestSum {
    public static int largestSum(int[] arr) {
        if(arr == null || arr.length == 0) {
            return 0;
        }
        return largestSum(arr,0,arr.length - 1);
    }

    static int largestSum(int[] arr,int low, int high) {
        if(arr[low] == arr[high]) {
            return arr[low];
        }
        int mid = (low + high) / 2;

        int temp = 0;
        int left = Integer.MIN_VALUE;
        for(int i = mid; i >= low;i--) {
            temp += arr[i];
            if(temp > left) {
                left = temp;
            }
        }

        temp = 0;
        int right = Integer.MIN_VALUE;
        for(int i = mid + 1; i <= high;i++) {
            temp += arr[i];
            if(temp > right) {
                right = temp;
            }
        }

        return Math.max(left + right,Math.max(largestSum(arr,low,mid) ,largestSum(arr,mid + 1,high)));
    }
}
