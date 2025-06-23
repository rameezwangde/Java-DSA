package Arrays;
import java.util.Scanner;
public class Swap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[]arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println("enter first index to swap:");
        int index1=sc.nextInt();
        System.out.println("enter second index to swap:");
        int index2=sc.nextInt();

        if(index1<0||index2<0 ||index1>=n||index2>=n){
            System.out.println("invalid index");
        }else{
            int temp=arr[index1];
            arr[index1]=arr[index2];
            arr[index2]=temp;
        }

        System.out.println("Array after swapping");
        for(int num:arr){
            System.out.println(num+" ");
        }
    }
}
