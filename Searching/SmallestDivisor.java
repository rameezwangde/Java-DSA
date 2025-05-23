package Searching;

public class SmallestDivisor {

    public static void main(String[] args) {
        // Example input
        int[] nums = {1, 2, 5, 9};
        int threshold = 6;

        // Call the static method directly
        int result = smallestDivisor(nums, threshold);

        // Output the result
        System.out.println("Smallest Divisor: " + result);
    }

    // Main logic method
    public static int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = getMax(nums);
        int answer = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int sum = getCeilSum(nums, mid);

            if (sum > threshold) {
                low = mid + 1;  // need a larger divisor
            } else {
                answer = mid;   // valid, try smaller
                high = mid - 1;
            }
        }

        return answer;
    }

    // Helper to get max element in array
    public static int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    // Helper to get sum of ceil divisions
    public static int getCeilSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;  // ceil(num / divisor)
        }
        return sum;
    }
}

