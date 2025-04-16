package Stack;

import java.util.Stack;

public class NSe {
    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};
        int[] result = nextSmallerElement(arr);

        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    public static int[] nextSmallerElement(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            // While stack is not empty and current element is smaller
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int idx = st.pop();
                ans[idx] = arr[i];
            }
            st.push(i);
        }

        // For elements that didn't find a smaller element
        while (!st.isEmpty()) {
            ans[st.pop()] = -1;
        }

        return ans;
    }
}
