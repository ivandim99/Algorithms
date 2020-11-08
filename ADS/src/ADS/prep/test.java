package ADS.prep;

public class test {

    public static void sort(int[] a) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0;i < a.length;i++) {
            if(a[i] > max) max = a[i];
            if(a[i] < min) min = a[i];
        }

        System.out.println(max);
        System.out.println(min);
        System.out.println(" ");

        int[] ret = new int[max - min + 1];

        for(int i = 0;i < ret.length;i++) {
            int j = a[i] - min;
            ret[j] = a[i];
        }

        for(int i = 0;i < ret.length;i++) {
            System.out.println(ret[i]);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 5, 7,3 , 4,6};
        sort(a);
    }

}
