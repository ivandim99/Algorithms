package ADS.prep;

public class CountReps {

        public static int[] count(int[] arr,int r) {
            if(arr == null || arr.length == 0) return null;
                int[] ret = new int[r+1];
                for(int i = 0;i < arr.length;i++) {
                    for(int j = 0;j <= r;j++) {
                        if(arr[i] == j) ret[j]++;
                    }
                }
                return ret;
        }


        public static void main(String[] args) {
            int[] a = {0 , 1, 1 , 3 ,3 , 3};
            int[] ret = count(a,4);
            for(int i =0 ;i< ret.length;i++) {
                System.out.println(ret[i]);
            }
        }

}
