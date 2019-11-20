package week2;

public class CumulativeSums1 {

    public static void cumulitiveSums(int[] a,int[] b,int i) {
        if(i < 0) return;
        for(int j = 0;j <= i;j++)
            b[i] += a[j];
        cumulitiveSums(a,b,i - 1);
    }

    public static int[] cumulitiveSums(int[] a) {
        int[] b = new int[a.length];
        cumulitiveSums(a,b,a.length - 1);
        return b;
    }
}
