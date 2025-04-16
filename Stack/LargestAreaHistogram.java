package Stack;

import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Max Area: " + largestRectangleArea(heights));
    }
    public static int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nser=nextSmallerElementIndexRight(heights);
        int[] nser2=nextSmallerElementIndexLeft(heights);
        int maxArea = 0;
        for(int i=0;i<n;i++){
            int ht=heights[i];
            int x1=nser[i]-1;
            int x2=nser2[i]+1;
            int wd=x1-x2+1;
            int area=ht*wd;
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }

    public static int[] nextSmallerElementIndexRight(int[] arr) {
        int n=arr.length;
        Stack<Integer>st=new Stack<>();
        int[]ans=new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                int idx=st.pop();
                ans[idx]=i;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int idx=st.pop();
            ans[idx]=n;;
        }
        return ans;
    }
    public static int[] nextSmallerElementIndexLeft(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                int idx = st.pop();
                ans[idx] = i;
            }
            st.push(i);
        }

        while (!st.isEmpty()) {
            ans[st.pop()] = -1; // No smaller element to the left
        }

        return ans;
    }
}
