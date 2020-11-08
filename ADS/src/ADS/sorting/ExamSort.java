package ADS.sorting;

public class ExamSort {

    public static void main(String[] args) {

        String[] input = {"hello", "chat", "ap", "damn", "bo"};
        sort(input);
    }


    public static void sort(String[] arr) {
        String[] unsorted = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            unsorted[i] = arr[i];
        }
        int[] ret = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            String curr = arr[i];
            int j = i - 1;
            while (j >= 0 && curr.compareTo(arr[j]) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = curr;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (unsorted[i] == arr[j])
                    ret[i] = j;
            }
        }
        for (int i = 0; i < ret.length; i++) {
            System.out.print(ret[i] + " ");
        }
    }
}
