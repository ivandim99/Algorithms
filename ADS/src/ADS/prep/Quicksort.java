package ADS.prep;


public class Quicksort {

    public static void quickSort(int[] arr) {
        if (arr.length <= 1) return;
        int low = 0;
        int high = 0;
        int pivot = arr[arr.length - 1];


        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < pivot) low++;
            else high++;
        }

        int left[] = new int[low];
        int right[] = new int[high];
        low = 0;
        high = 0;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < pivot) left[low++] = arr[i];
            else right[high++] = arr[i];
        }
        quickSort(left);
        quickSort(right);

        for (int i = 0; i < arr.length; i++) {
            if (i < low) arr[i] = left[i];
            else if (i == low) arr[i] = pivot;
            else arr[i] = right[i - left.length - 1];
        }

    }

    public static void main(String[] args) {
        int[] a = {9, 7, 5, 12, 11, 2, 14, 10};
        quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

