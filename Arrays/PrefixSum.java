package Arrays;

import java.util.Scanner;

public class PrefixSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
          System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[]prefixsum=new int[n];
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=0;j<=i;j++){
                sum+=arr[j];
            }
            prefixsum[i]=sum;
        }
           System.out.println("Prefix sum array:");
        for (int i = 0; i < n; i++) {
            System.out.print(prefixsum[i] + " ");
        }
    }
}
