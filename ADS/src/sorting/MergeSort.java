package sorting;

public class MergeSort {

    public static void mergeSort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int size1 = mid - l + 1;
        int size2 = r - mid;

        int arr1[] = new int[size1];
        int arr2[] = new int[size2];

        for (int i = 0; i < size1; i++) {
            arr1[i] = arr[l + i];
        }
        for (int j = 0; j < size2; j++) {
            arr2[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < size1 && j < size2) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < size1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < size2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
//        int[] arr1 = {1,32,4,4546,7,8,99,8,95,1203};
//        mergeSort(arr1,0,arr1.length - 1);
//        for (int i = 0;i<arr1.length;i++) {
//            System.out.println(arr1[i]);
//        }
        int l = 0;
        int r = arr.length - 1;
        int mid = l + (r - l) / 2;
//        for (int i = r;i>mid;i--) {
//            System.out.print(arr[i]);
//        }
//        System.out.println();
//        for (int j = 0;j <mid + 1;j++) {
//            System.out.print(arr[j]);
//        }
//        System.out.println();
//        for (int j = 0;j <mid - l + 1;j++) {
//            System.out.print(arr[j]);
//        }
//        System.out.println();
        System.out.println(mid);
    }


}
