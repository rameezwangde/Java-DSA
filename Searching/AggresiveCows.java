package Searching;

public class AggresiveCows {
    public static void main(String[] args) {
        int[]stalls={1,2,4,8,9};
        int res=aggressiveCows(stalls, 3);
        System.out.print("Minimum Distance:"+res);
    }
    public static int aggressiveCows(int[]stalls,int k){
        int low=1;
        int high=stalls[stalls.length-1]-stalls[0];
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            int cowsplaced=1;
            int lastpos=stalls[0];
            for(int i=1;i<stalls.length;i++){
                if(stalls[i]-lastpos>=mid){
                    cowsplaced++;
                    lastpos=stalls[i];
                }
            }
            if(cowsplaced>=k){
                ans=mid;
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}
