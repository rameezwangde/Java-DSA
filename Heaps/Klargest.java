package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Klargest {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = findKthLargest(nums, k);
        System.out.println(k + "th Largest Element: " + result);  // Expected Output: 5
    }

    public static int findKthLargest(int[]nums,int k){
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums){
            maxHeap.add(num);

        }
        for(int i=1;i<k;i++){
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}
