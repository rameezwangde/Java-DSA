package Arrays;
import java.util.Scanner;
public class Reverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the array");
        int n=sc.nextInt();
        int arr[]=new int[n];
        System.out.println("Enter the elements of the array");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("Original array is:");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        reverse(arr, n);
       System.out.println("reverse array:");
       for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
       }
    }
    public static void reverse(int[]arr,int n){
        int start=0;
        int end=n-1;
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}
