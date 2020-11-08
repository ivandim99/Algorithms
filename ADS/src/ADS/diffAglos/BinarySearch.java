package ADS.diffAglos;

public class BinarySearch {

    public static boolean search(int[] arr,int target,int low,int high) {
        if(low>high) return false;
        else {
            int mid = (low + high) / 2;
            if(target == arr[mid]) return true;
            else if(target < mid) {
                return search(arr,target,low,mid-1);
            }
            else {
                return search(arr,target,mid+1,high);
            }
        }
    }

    public static boolean search(int[] arr,int target) {
        return search(arr,target,0,arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = {12,3,34,3,4,6,34,6,8,54,3,7,8,78,67,8,769};
        System.out.println(search(arr,8));
        System.out.println(search(arr,33131));
    }

}
