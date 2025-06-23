package Arrays;
import java.util.Scanner;

public class PartialReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter the elements of the array");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Original array is:");
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // Get part to reverse
        System.out.print("\nEnter start index to reverse: ");
        int startIndex = sc.nextInt();
        System.out.print("Enter end index to reverse: ");
        int endIndex = sc.nextInt();

        // Validate indices
        if(startIndex < 0 || endIndex >= n || startIndex >= endIndex) {
            System.out.println("Invalid indices. No changes made.");
        } else {
            reverse(arr, startIndex, endIndex);

            System.out.println("Array after partial reverse:");
            for(int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
        }

        sc.close();
    }

    // Reverse only from startIndex to endIndex
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
