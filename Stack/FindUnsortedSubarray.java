package Stack;

public class FindUnsortedSubarray {
    public static void main(String[] args) {
        // Example input array (you can change it for different test cases)
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        
        // Calling the function to find the unsorted subarray length
        int result = findUnsortedSubarray(nums);
        
        // Output the result
        System.out.println("Length of shortest unsorted subarray: " + result);
    }

    // Function to find the shortest unsorted subarray
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;  // Length of the array
        
        // Initialize variables to track max and min values during the traversals
        int max = nums[0];  // Start with the first element
        int min = nums[n - 1];  // Start with the last element
        
        // Set high and low boundaries for the unsorted subarray
        int high = 0, low = 1;

        // Traverse the array from both ends (left to right and right to left)
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            // If current element is less than the max encountered so far, update 'high'
            if (nums[i] < max) high = i;
            
            // If current element is greater than the min encountered so far, update 'low'
            if (nums[j] > min) low = j;
            
            // Update max and min as we continue traversing
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[j]);
        }

        // If the array is already sorted, 'high' will be less than 'low', return 0
        // Otherwise, return the length of the unsorted subarray
        return high - low + 1;
    }
}


