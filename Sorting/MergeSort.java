package Sorting;

import java.util.ArrayList;

public class MergeSort {

    // Merge two sorted subarrays: arr[low..mid] and arr[mid+1..high]
    public static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        // Merge the two sorted halves
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // Add remaining elements of left half
        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        // Add remaining elements of right half
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // Copy the sorted elements back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    // Recursive merge sort function
    public static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;

        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);       // Sort left half
        mergeSort(arr, mid + 1, high);  // Sort right half
        merge(arr, low, mid, high);     // Merge them
    }

    // Main method
    public static void main(String[] args) {
        int[] arr = {9, 4, 7, 6, 3, 1, 5};
        int n = arr.length;

        System.out.println("Before sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Call mergeSort
        mergeSort(arr, 0, n - 1);

        System.out.println("After sorting:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
