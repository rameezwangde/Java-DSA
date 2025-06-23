package Arrays;

import java.util.Scanner;

public class PrefixOptimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Optimal prefix sum calculation
        int[] prefixSum = new int[n];
        prefixSum[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        // Print prefix sum array
        System.out.println("Prefix sum array:");
        for (int i = 0; i < n; i++) {
            System.out.print(prefixSum[i] + " ");
        }

        sc.close();
    }
}
