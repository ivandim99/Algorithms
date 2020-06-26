//package prep;
//
//import DataStructures.PriorityQueue.PriorityQueue;
//
//import java.util.LinkedList;
//import java.util.NoSuchElementException;
//
//public class Bucketsort {
//
//    public static Queue<Integer>[] fillBuckets(int[] array) {
//        if (array.length == 0 || array == null) return new Queue[0];
//        int vmin = Integer.MAX_VALUE;
//        int vmax = Integer.MIN_VALUE;
//
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] < vmin) vmin = array[i];
//            if (array[i] > vmax) vmax = array[i];
//        }
//
//        Queue<Integer>[] buckets = new Queue[vmax - vmin + 1];
//
//        for (int i = 0; i < buckets.length; i++) {
//            buckets[i] = new LinkedList<Integer>();
//        }
//
//        for (int i = 0; i < array.length; i++) {
//            buckets[array[i] - vmin].add(array[i]);
//        }
//        return buckets;
//    }
//
//    public static int[] readBuckets(Queue<Integer>[] buckets) {
//        int size = 0;
//
//        for (int i = 0; i < buckets.length; i++) {
//            size += buckets[i].size();
//        }
//
//        int[] result = new int[size];
//        int counter = 0;
//
//        for (int i = 0; i < buckets.length; i++) {
//            while (buckets[i].size() != 0) {
//                result[counter] = buckets[i].remove();
//                counter++;
//            }
//        }
//        return result;
//    }
//}
