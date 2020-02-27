package diffAglos;

public class BinaryRecursion {

    public static int binarySum(int[] data, int low, int high) {
        if (low > high)
            return 0;
        else if (low == high)
            return data[low];
        else {
            int mid = (low + high) / 2;
            return binarySum(data, low, mid) + binarySum(data, mid + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 3, 4, 5, 6, 7};
        System.out.print(binarySum(data, 0, 6));

    }

}
