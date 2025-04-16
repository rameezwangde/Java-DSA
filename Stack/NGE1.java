package Stack;

import java.util.*;

public class NGE1 {

    // Inner class to hold the solution logic
    static class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] ans = new int[nums1.length];
            Stack<Integer> st = new Stack<>();
            Map<Integer, Integer> mp = new HashMap<>();

            // Find next greater for each element in nums2
            for (int i = 0; i < nums2.length; i++) {
                int num = nums2[i];
                while (!st.isEmpty() && num > st.peek()) {
                    int smaller = st.pop();
                    mp.put(smaller, num);
                }
                st.push(num);
            }

            // Build result for nums1 using the map
            for (int i = 0; i < nums1.length; i++) {
                ans[i] = mp.getOrDefault(nums1[i], -1);
            }

            return ans;
        }
    }

    public static void main(String[] args) {
        // Sample test case
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        Solution sol = new Solution();
        int[] result = sol.nextGreaterElement(nums1, nums2);

        // Output the result
        System.out.println("Next Greater Elements:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
