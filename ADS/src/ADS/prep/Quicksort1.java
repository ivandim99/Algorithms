package ADS.prep;

public class Quicksort1 {

    public static void quickSort(int[] arr, int low, int high) {
        if(low < high) {
            int partition = partition(arr,low,high);

            quickSort(arr,low,partition - 1);
            quickSort(arr,partition + 1,high);
        }
    }

    public static int partition(int[] arr,int low,int high) {
        int pivot = arr[high];
        int j = low - 1;
        for(int i = low;i <= high - 1;i++) {
            if(arr[i] < pivot) {
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j + 1];
        arr[j + 1] = arr[high];
        arr[high] = temp;
        return j + 1;
    }

    public static void main(String[] args) {
        int[] a = {9, 7, 5, 12, 11, 2, 14, 10};
        quickSort(a,0,a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
