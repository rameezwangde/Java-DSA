package Arrays;

public class Kadanes {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};  // Example array
        int maxSum = Kadanes(arr);
        System.out.println("Maximum Subarray Sum is: " + maxSum);
    }

    // Kadane's Algorithm to find maximum sum of contiguous subarray
    public static int Kadanes(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (sum >= 0) {
                sum += arr[i];
            } else {
                sum = arr[i];
            }
            ans = Math.max(ans, sum);
        }

        return ans;
    }
}
