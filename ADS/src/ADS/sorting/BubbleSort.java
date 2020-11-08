package ADS.sorting;

public class BubbleSort {

    public static void main(String[] args) {

        int[] input = {3, 45, 6, 342, 7, 9, 1, 2};
        sort(input);
        for (int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
