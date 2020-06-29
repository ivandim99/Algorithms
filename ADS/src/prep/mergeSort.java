package prep;

import java.util.Arrays;

public class mergeSort {


    public static void sort(int[] a) {
        int l = 0;
        int r = a.length - 1;
        int m = (r + l)/2;
        int[] left = Arrays.copyOfRange(a,l,m);
        int[] right = Arrays.copyOfRange(a,m + 1,a.length);
    }



    public static void main(String[] args) {
        int a[] = {1,2,3,4,5,6,7,8};
        int l = 0;
        int r = a.length - 1;
        int m = a.length/2;
        int[] left = Arrays.copyOfRange(a,0,m);
        int[] right = Arrays.copyOfRange(a,m,a.length);
        for(int i =0 ;i < left.length;i++) {
            System.out.println(left[i] + "l");
        }

        for(int i =0 ;i < left.length;i++) {
            System.out.println(right[i] + "r");
        }
    }

}
