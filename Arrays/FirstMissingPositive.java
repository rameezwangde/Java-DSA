package Arrays;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        System.out.println(firstMissingPositive(nums)); // Output: 2
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;

        // Step 1: Place elements at correct index using cyclic sort logic
        while (i < n) {
            int correctIndex = nums[i] - 1;
            if (nums[i] > 0 && nums[i] <= n && nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        // Step 2: Find the first index where nums[i] != i + 1
        for (i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all elements are in place, return n + 1
        return n + 1;
    }

    // Utility function to swap elements
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

