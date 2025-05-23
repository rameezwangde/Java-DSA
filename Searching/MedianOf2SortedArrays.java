package Searching;

public class MedianOf2SortedArrays {
    public static void main(String[] args) {
        int[]nums1={1,4,7,10,12};
        int [] nums2={2,3,6,15};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[]nums1,int[]nums2){
        int n1=nums1.length;
        int n2=nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int low=0;
        int high=n1;
        int total=n1+n2;
        int half=(total+1)/2;
        while(low<=high){
            int mid1=(low+high)/2;
            int mid2=half-mid1;
            int l1=(mid1==0)?Integer.MIN_VALUE:nums1[mid1-1];
            int l2=(mid2==0)?Integer.MIN_VALUE:nums2[mid2-1];
            int r1=(mid1==n1)?Integer.MAX_VALUE:nums1[mid1];
            int r2=(mid2==n2)?Integer.MAX_VALUE:nums2[mid2];
            if(l1<=r2 && l2<=r1){
                if((total%2==0)){
                    return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
                else{
                    return Math.max(l1,l2);
                }
            }else if(l1>r2){
                high=mid1-1;
            }else{
                low=mid1+1;
            }
        }
        return 0.0;
    }
}
