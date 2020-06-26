package prep;

public class ReverseAnArray {

    public static void reverse(int[] arr) {

        if(arr == null || arr.length == 0) return;
        for(int i = 0, j = arr.length - 1;i < j;i++,j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

    }

}
