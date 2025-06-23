package Arrays;

import java.util.Scanner;

public class Swapfn {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter " + n + " elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input two indices to swap
        System.out.print("Enter first index to swap: ");
        int index1 = sc.nextInt();

        System.out.print("Enter second index to swap: ");
        int index2 = sc.nextInt();

        // Check for valid indices
        if(index1 < 0 || index1 >= n || index2 < 0 || index2 >= n) {
            System.out.println("Invalid indices! Swapping aborted.");
        } else {
            // Call the swap function
            swap(arr, index1, index2);

            // Print updated array
            System.out.println("Swapped array is:");
            for(int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        }

        sc.close();
    }

    // Function to swap elements at two given indices
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
