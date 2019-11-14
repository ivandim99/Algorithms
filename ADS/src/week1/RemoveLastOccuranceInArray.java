package week1;

public class RemoveLastOccuranceInArray {
    /**
     * Takes the array and the last occurring element x,
     * shifting the rest of the elements left. I.e.
     * [1, 4, 7, 9], with x=7 would result in:
     * [1, 4, 9].
     *
     * @param x   the entry to remove from the array
     * @param arr to remove an entry from
     * @return the updated array, without the last occurrence of x
     */
    public static int[] removeLastOccurrence(int x, int[] arr) {
        if (arr == null || arr.length <= 0) return new int[0];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) index = i;
        }
        int[] ret = new int[arr.length - 1];
        for (int j = 0, i = 0; j < arr.length; j++, i++) {
            if (j == index) {
                i--;
            } else ret[i] = arr[j];
        }
        for(int i =0;i<ret.length;i++) {
            System.out.println(ret[i]);
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 1, 3, 4, 5, 11};
        removeLastOccurrence(1, arr);

    }
}
