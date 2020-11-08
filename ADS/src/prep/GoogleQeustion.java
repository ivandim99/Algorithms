package prep;

public class GoogleQeustion {

    public static boolean  check(int[] arr,int sum) {
        if(arr.length == 0 || arr == null) return false;
        int a = 0;
        int b = arr.length - 1;
        int[] ret = new int[2];
        while(a < b) {
            if(arr[a] + arr[b] > sum) b--;
            if(arr[a] + arr[b] < sum) a++;
            else {
                ret[0] = arr[a];
                ret[1] = arr[b];
                System.out.println(ret[0] + " and " + ret[1]);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {1,2,2,2,2,2,2,2,3,3,3,4,4,5};
        int sum = 8;
        System.out.println(check(a,sum));
    }

}
