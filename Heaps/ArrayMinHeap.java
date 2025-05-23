package Heaps;

public class ArrayMinHeap {

    public static boolean isHeap(int[] arr, int n) {
        // Start from the root and traverse the whole array
        for (int i = 0; i <= (n - 2) / 2; i++) {
            // If left child is smaller, return false
            if (2 * i + 1 < n && arr[2 * i + 1] < arr[i]) {
                return false;
            }

            // If right child is smaller, return false
            if (2 * i + 2 < n && arr[2 * i + 2] < arr[i]) {
                return false;
            }
        }
        // Return true if we exit the loop
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 30, 40, 50, 100, 40};
        int n = 7;

        // Print true if the given array represents min-heap, else false
        if (isHeap(arr, n)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
