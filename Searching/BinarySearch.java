package Searching;

public class BinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int n=arr.length;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==target) return mid;
            else if(target>arr[mid]) low=mid+1;
            else high=mid-1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,7,8,9,10};
        int target=9;
        int res=binarySearch(arr, target);
         if (res != -1)
            System.out.println("Target found at index: " + res);
        else
            System.out.println("Target not found in the array.");
    }

}
