package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Ksmallest {
    public static void main(String[] args) {
        int[] nums = {7, 10, 4, 3, 20, 15};
        int k = 3;

        int result = findKthSmallest(nums, k);
        System.out.println(k + "th Smallest Element: " + result);  // Output: 7
    }

    public static int findKthSmallest(int[] nums, int k) {
        // Max-heap to store the k smallest elements
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            maxHeap.add(num);  // Add current number to heap

            // If size exceeds k, remove the largest (top of the max heap)
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Top of the max-heap is the kth smallest element
        return maxHeap.peek();
    }
}
