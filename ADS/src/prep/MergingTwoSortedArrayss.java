package prep;

public class MergingTwoSortedArrayss {

    public static int[] merge(int[] arr1,int[] arr2) {

        if(arr1 == null && arr2 == null) return null;
        if(arr1 == null && arr2 != null) return arr2;
        if(arr1 != null && arr2 == null) return arr1;

        int[] ret = new int[arr1.length + arr2.length];
        int size = 0;
        int i = 0;
        int j = 0;
        while(size < ret.length) {
            if(i < arr1.length && j < arr2.length) {
                if(arr1[i] < arr2[j]) {
                    ret[size++] = arr1[i++];
                } else {
                    ret[size++] = arr2[j++];
                }
            }
            else if(i < arr1.length) {
                ret[size++] = arr1[i++];
            }
            else if(j < arr2.length) {
                ret[size++] = arr2[j++];
            }
        }
        return ret;
    }


    public static void main(String[] args) {

        int[] a = {1,2,3,3,4,4,4,4,9};
        int[] b = {1,1,2,2,3,4,5,6,7};
        int[] ret = merge(a,b);
        for(int i = 0 ; i < ret.length;i++) {
            System.out.println(ret[i]);
        }

    }

}
