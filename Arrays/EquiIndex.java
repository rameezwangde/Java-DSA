package Arrays;

import java.util.Scanner;

public class EquiIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        // Input array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call function
        int pivot = eqIndex(nums);

        // Print result
        if (pivot != -1) {
            System.out.println("Equilibrium index is: " + pivot);
        } else {
            System.out.println("No equilibrium index found.");
        }

        sc.close();
    }

    public static int eqIndex(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }

        return -1;
    }
}

