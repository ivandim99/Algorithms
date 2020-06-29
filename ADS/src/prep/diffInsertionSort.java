package prep;

public class diffInsertionSort {

    public static void sort(int[] a) {
        int i = 0;
        int curr = a[i];
        while(i < a.length) {
            int j = i + 1;
            while(j < a.length) {
                if(a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
                j++;
            }
            i++;
        }
    }


    public static void main(String[] args) {
        int[] a = {5,2,4,3,7,1,8};
        sort(a);
        for(int i = 0;i < a.length;i++) {
            System.out.println(a[i]);
        }
    }

}
