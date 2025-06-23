package Arrays;

import java.util.Scanner;

public class Rotate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter the elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input rotation count
        System.out.print("Enter k (number of positions to rotate): ");
        int k = sc.nextInt();

        // Normalize k (in case k > n)
        k = k % n;

        // Print original array
        System.out.println("Original array is:");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        // Perform rotation using 3 reversals
        reverse(arr, 0, n - 1);     // Reverse whole array
        reverse(arr, 0, k - 1);     // Reverse first k elements
        reverse(arr, k, n - 1);     // Reverse the rest

        // Print rotated array
        System.out.println("\nRotated array is:");
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        sc.close();
    }

    // Reverse elements in arr from index 'start' to 'end'
    public static void reverse(int[] arr, int start, int end) {
        while(start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

