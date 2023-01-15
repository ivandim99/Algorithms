package DivideAndConquer;

import Greedy.minimizingLateness;

import java.util.HashSet;
import java.util.Set;

public class partialSums {

    /**
     * Computes all possible partial sums given an array of integers.
     *
     * @param arr - all values in the input set
     * @return set of sums
     */
    public static Set<Integer> partialSums(Integer[] arr) {
        if(arr.length == 0 || arr == null) {
            Set<Integer> ret = new HashSet<>();
            ret.add(0);
            return  ret;
        }
        return partialSums(arr,0,arr.length - 1);
    }

    static Set<Integer> partialSums(Integer[] arr,int low, int high) {
        Set<Integer> res = new HashSet<>();
        if(arr[low] == arr[high]) {
            res.add(arr[low]);
            res.add(0);
            return res;
        }

        int mid = (low + high) / 2;
        Set<Integer> left = partialSums(arr,low,mid);
        Set<Integer> right = partialSums(arr,mid + 1,high);

        for(int i : left) {
            for(int j : right) {
                res.add(i+j);
            }
        }

        return res;
    }

}
