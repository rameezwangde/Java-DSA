package Arrays;

import java.util.Arrays;

public class MergeArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1;
        int right = 0;

        // Swap larger elements of nums1 with smaller elements of nums2
        while (left >= 0 && right < n) {
            if (nums1[left] > nums2[right]) {
                int temp = nums1[left];
                nums1[left] = nums2[right];
                nums2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        // Sort both arrays individually
        Arrays.sort(nums1, 0, m);   // sort only the valid part of nums1
        Arrays.sort(nums2);         // sort nums2

        // Copy sorted nums2 into nums1 from index m onward
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 0, 0, 0};  // size m + n
        int[] nums2 = {2, 4, 6};
        int m = 3;
        int n = 3;

        merge(nums1, m, nums2, n);

        System.out.println("Merged array:");
        System.out.println(Arrays.toString(nums1)); // Output: [1, 2, 3, 4, 5, 6]
    }
}

