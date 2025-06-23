package Arrays;

public class RangeSumOptimal{
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10};

        int[][] queries = {
            {1, 3},  // sum of arr[1] to arr[3] = 4 + 6 + 8 = 18
            {0, 4},  // sum of arr[0] to arr[4] = 2 + 4 + 6 + 8 + 10 = 30
            {2, 2}   // sum of arr[2] to arr[2] = 6
        };

        int[] result = sumquery(arr, queries);

        System.out.println("Range Sum Results:");
        for (int sum : result) {
            System.out.println(sum);
        }
    }

    public static int[] sumquery(int[] arr, int[][] queries) {
       int q=queries.length;
       int[]res=new int[q];
       for(int i=0;i<q;i++){
        int l=queries[i][0];
        int r=queries[i][1];
        int sum=0;
        for(int j=l;j<=r;j++){
            sum+=arr[j];
        }
        res[i]=sum;
       }
       return res;
    }
}
