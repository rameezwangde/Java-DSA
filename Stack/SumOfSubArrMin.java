package Stack;

import java.util.Stack;

public class SumOfSubArrMin {
    
    // Modulo constant to avoid integer overflow
    private static final int MOD = 1_000_000_007;

    public static void main(String[] args) {
        SumOfSubArrMin solution = new SumOfSubArrMin();
        int[] arr = {3, 1, 2, 4};
        System.out.println("Sum of Subarray Minimums: " + solution.sumSubarrayMins(arr));
    }

    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        
        // Arrays to store indices of previous and next less elements
        int[] prevs = new int[n];
        int[] nexts = new int[n];

        Stack<Integer> st = new Stack<>();

        // Step 1: Compute previous less element index for each element
        for (int i = 0; i < n; i++) {
            // Pop from stack until top is less than current element
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            // If stack is empty, no smaller element to the left => set -1
            prevs[i] = st.isEmpty() ? -1 : st.peek();
            // Push current index onto the stack
            st.push(i);
        }

        // Clear the stack for next use
        st.clear();

        // Step 2: Compute next less element index for each element
        for (int i = n - 1; i >= 0; i--) {
            // For strictly smaller on right, use '<'; for duplicate handling, use '<='
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            // If stack is empty, no smaller element to the right => set to n (out of bounds)
            nexts[i] = st.isEmpty() ? n : st.peek();
            // Push current index onto the stack
            st.push(i);
        }

        long ans = 0;

        // Step 3: Calculate the total contribution of each element
        for (int i = 0; i < n; i++) {
            // Number of elements on the left where arr[i] is the min
            long left = i - prevs[i];
            // Number of elements on the right where arr[i] is the min
            long right = nexts[i] - i;

            // Contribution = left * right * arr[i]
            // Use modulo at every step to avoid overflow
            long contribution = (left * right) % MOD;
            contribution = (contribution * arr[i]) % MOD;
            ans = (ans + contribution) % MOD;
        }

        return (int) ans;
    }
}
