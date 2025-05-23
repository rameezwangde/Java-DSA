package Searching;

public class TimesUpdatingArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2, 3};
        int ans = findKRotation(arr);
        System.out.println("The array is rotated " + ans + " times.");
    }

    // Function to find the index of the minimum element,
    // which is equal to the number of times the array has been rotated
    public static int findKRotation(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;

        int ans = Integer.MAX_VALUE;  // To store the smallest value found
        int index = -1;               // To store index of smallest value (i.e., rotation count)

        while (low <= high) {
            int mid = (low + high) / 2;

            // If the current subarray is already sorted
            // then the smallest element is at index `low`
            if (arr[low] <= arr[high]) {
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                break; // no need to search further
            }

            // If the left half is sorted
            if (arr[low] <= arr[mid]) {
                // Update answer if current low is smaller
                if (arr[low] < ans) {
                    index = low;
                    ans = arr[low];
                }
                // Minimum must be in right half
                low = mid + 1;
            }
            // Otherwise, the right half is sorted
            else {
                // Update answer if current mid is smaller
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }
                // Minimum must be in left half
                high = mid - 1;
            }
        }
        return index;  // Index of minimum element = number of rotations
    }
}

