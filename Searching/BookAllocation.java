package Searching;
public class BookAllocation {
    public static void main(String[] args) {
        int[]arr={12,34,67,90};
        int res=findPages(arr, 2);
        System.out.print("minimum pages:"+res);
    }
    public static int findPages(int[]arr,int k){
        int n=arr.length;
        if(k>n) return -1;
        int low=0;
        int high=0;
        for(int pages:arr){
            low=Math.max(low,pages);
            high+=pages;
        }
        int ans=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            int students=1;
            int currpages=0;
            for(int pages:arr){
                if(currpages+pages>mid){
                    students++;
                    currpages=pages;
                }else{
                    currpages+=pages;
                }
            }
            if(students<=k){
                    ans=mid;
                    high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }

}
