package Arrays;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};  // Test case

        List<Integer> result = majorityElement(nums);  // Call the static method

        System.out.println("Majority Elements (> n/3): " + result);  // Output: [1, 2]
    }

    public static List<Integer> majorityElement(int[] nums) {
        int count1 = 0, count2 = 0;
        Integer candidate1 = null, candidate2 = null;

        // First pass: find potential candidates
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Second pass: verify actual counts
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;  // Use else-if to avoid double counting
        }

        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if (count1 > n / 3) res.add(candidate1);
        if (count2 > n / 3) res.add(candidate2);

        return res;
    }
}

