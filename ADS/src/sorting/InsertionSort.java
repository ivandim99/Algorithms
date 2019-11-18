package sorting;

public class InsertionSort {

    public static void sort(int[] arr) {
        for(int i=0;i<arr.length;i++) {
            int current = arr[i];
            int j = 0;
            while(arr[i + j] < current) {
                int now = arr[i + j];
                swap(current,now);
                j++;
            }
        }
    }
    public static void swap(int x,int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,31,1,2,34,56,7,8,7,86};
        sort(arr);
        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}
