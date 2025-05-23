package Heaps;

import java.util.*;

public class DivideInSets {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4,5,6};
        int k = 4;
        
        boolean result = isPossibleDivide(nums, k);
        System.out.println("Can be divided: " + result);
    }

    public static boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if (n % k != 0) return false;

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(freq.keySet());

        while (!minHeap.isEmpty()) {
            int first = minHeap.peek();

            for (int i = 0; i < k; i++) {
                int current = first + i;
                if (!freq.containsKey(current)) return false;

                freq.put(current, freq.get(current) - 1);
                if (freq.get(current) == 0) {
                    freq.remove(current);
                    if (!minHeap.isEmpty() && minHeap.peek() == current) {
                        minHeap.poll();
                    }
                }
            }
        }

        return true;
    }
}
