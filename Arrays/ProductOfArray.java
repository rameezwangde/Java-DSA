package Arrays;

import java.util.Arrays;

public class ProductOfArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productOfArray(nums);

        System.out.println("Product of array except self:");
        System.out.println(Arrays.toString(result));
    }

    public static int[] productOfArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Step 1: Compute left product
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Step 2: Multiply with right product
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] = ans[i] * right;
            right = right * nums[i];
        }

        return ans;
    }
}

