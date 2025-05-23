package Searching;

public class SingleElement {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 4, 5, 5}; // Example input
        int res=singleNonDuplicate(nums);
        System.out.println("The single non duplicate element is: "+res);

    }

    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;

        // Handle edge cases
        if (n == 1) return nums[0];
        if (nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int low = 1, high = n - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Check if mid is the unique element
            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }

            // Determine which half to discard
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) ||
                (mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                // Proper pair found → go right
                low = mid + 1;
            } else {
                // Broken pair → go left
                high = mid - 1;
            }
        }

        return -1; // Shouldn't reach here due to constraints
    }
}

