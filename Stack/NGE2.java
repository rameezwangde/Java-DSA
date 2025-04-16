
// nge using circular array
package Stack;

import java.util.*;

public class NGE2 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {1, 2, 1};
        int[] result = sol.nextGreaterElements(nums);

        System.out.println("Next Greater Elements:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        // Initialize answer array with -1
        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }

        // Loop through the array twice (circular array)
        for (int i = 0; i < n * 2; i++) {
            while (!st.isEmpty() && nums[i % n] > nums[st.peek()]) {
                int index = st.pop();              // get the index from stack
                int nextGreater = nums[i % n];     // get the next greater element
                ans[index] = nextGreater;          // store it in result array
            }

            if (i < n) {
                st.push(i); // push index (not value) for tracking
            }
        }

        return ans;
    }
}

