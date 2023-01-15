package DivideAndConquer;
public class sortingAndCounting {

    static
    /**
     * This method is used to count the number of inversions in the array and also sorts the array.
     *
     * @param array The array to be sorted.
     * @return The number of inversions in the array.
     */
    int countInversions(int[] array) {
        return sortAndCount(array, 0, array.length - 1);
    }

    static int sortAndCount(int[] array, int left, int right) {
        int inversions = 0;
        int mid;
        if (left < right) {
            mid = (left + right) / 2;
            inversions = sortAndCount(array, left, mid);
            inversions += sortAndCount(array, mid + 1, right);
            inversions += mergeAndCount(array, left, mid + 1, right);
        }
        return inversions;
    }

    static int mergeAndCount(int[] array, int left, int mid, int right) {
        int inversions = 0;
        int[] res = new int[array.length];
        int i = left;
        int j = mid;
        int k = left;

        while ((i <= mid - 1) && (j <= right)) {
            if (array[j] >= array[i]) {
                res[k++] = array[i++];
            } else {
                res[k++] = array[j++];
                inversions = inversions + (mid - i);
            }
        }
        while (i <= mid - 1) {
            res[k++] = array[i++];
        }
        while (j <= right) {
            res[k++] = array[j++];
        }
        for (i = left; i <= right; i++) {
            array[i] = res[i];
        }
        return inversions;
    }
}
