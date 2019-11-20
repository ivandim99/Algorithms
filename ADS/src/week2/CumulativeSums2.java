package week2;

public class CumulativeSums2 {

    public static void cumulativeSums(int[] a) {
        if(a.length == 0) return;
        int[] b = new int[a.length];
        b[0] = a[0];
        for(int i=0;i < a.length;i++) {
            b[i] = b[i - 1] + a[i];
        }
        for(int j=0;j<a.length;j++) {
            a[j] = b[j];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        cumulativeSums(arr);
        for(int i =0 ;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }

}
