package Heaps;
import java.util.PriorityQueue;

public class NearlySorted {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;

        sortKSortedArray(arr, k);

        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    static void sortKSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int n = arr.length;

        // Step 1: Build min heap of first k+1 elements
        for (int i = 0; i < Math.min(k + 1, n); i++) {
            minHeap.offer(arr[i]);
        }

        int index = 0;

        // Step 2: Process remaining elements, push and pop from heap
        for (int i = k + 1; i < n; i++) {
            arr[index++] = minHeap.poll(); // smallest element from heap goes to array
            minHeap.offer(arr[i]);          // add next element to heap
        }

        // Step 3: Extract remaining elements from heap and place in array
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}


