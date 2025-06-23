package Arrays;

import java.util.Scanner;

public class CountGreater {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input elements
        System.out.println("Enter array elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Call function to count greater-than-so-far elements
        int result = countGreater(arr);
        System.out.println("Number of elements greater than all previous ones: " + result);

        sc.close();
    }

    public static int countGreater(int[] arr) {
        int count = 0;
        int maxSoFar = arr[0];  // Start with first element

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > maxSoFar) {
                count++;
                maxSoFar = arr[i];  // Update the new max
            }
        }

        return count;
    }
}
