package Searching;

public class Ksearch2 {
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        int target = 0;

        boolean ans = new Ksearch2().search(arr, target);
        System.out.println("Is target " + target + " present? " + ans);
    }

    // Method to search target in rotated sorted array (with possible duplicates)
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            // Target found
            if (nums[mid] == target) return true;

            // Duplicates: shrink window
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
                continue;
            }

            // Left half is sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }
}

