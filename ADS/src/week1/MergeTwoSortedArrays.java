package week1;

public class MergeTwoSortedArrays {

    /**
     * Merges two sorted arrays such that the resulting array has all elements
     * from both arrays and is also sorted. Assumes that the elements in the
     * given arrays are sorted in non-decreasing order. If there are duplicate
     * elements in the input arrays, these should also be present in the
     * resulting array. If both arrays are null the result should be null, or a
     * copy of the non-null array if only one is null.
     * <p>
     * Efficiency requirements: merge the two arrays in a single pass.
     *
     * @param arr1 first sorted array to be merged
     * @param arr2 second sorted array to be merged
     * @return sorted array containing all elements from both arrays
     */
    public static int[] merge(int[] arr1, int[] arr2) {
        if (arr1 == null && arr2 == null) return null;
        if (arr1 == null && arr2 != null) return arr2;
        if (arr1 != null && arr2 == null) return arr1;

        int[] ret = new int[arr1.length + arr2.length];
        int size = 0;
        int i = 0;
        int j = 0;
        while (size < ret.length) {
            if (i < arr1.length && j < arr2.length) {
                if (arr1[i] < arr2[j]) {
                    ret[size++] = arr1[i++];
                } else {
                    ret[size++] = arr2[j++];
                }

            } else if (i < arr1.length) {
                ret[size++] = arr1[i++];

            } else if (j < arr2.length) {
                ret[size++] = arr2[j++];
            }
        }
        return ret;
    }
}
