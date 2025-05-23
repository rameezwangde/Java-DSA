package Searching;

public class Kthelement {
    public static void main(String[] args) {
        int[]a={2,3,6,7,9};
        int[]b={1,4,8,10};
        int k=5;
        System.out.println(kthelement(a, b, k));
    }

    public static int kthelement(int[]a,int[]b,int k){
        int n1 = a.length, n2 = b.length;

        // Always binary search on the smaller array
        if (n1 > n2) return kthelement(b, a, k);

        // Define the binary search range
        int low = Math.max(0, k - n2);
        int high = Math.min(k, n1);

        while (low <= high) {
            int mid1 = (low + high) / 2;     // number of elements picked from a
            int mid2 = k - mid1;             // remaining picked from b

            // Edge conditions for left elements
            int l1 = (mid1 == 0) ? Integer.MIN_VALUE : a[mid1 - 1];
            int l2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1];

            // Edge conditions for right elements
            int r1 = (mid1 == n1) ? Integer.MAX_VALUE : a[mid1];
            int r2 = (mid2 == n2) ? Integer.MAX_VALUE : b[mid2];

            // Valid partition found
            if (l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2); // K-th element is max of lefts
            } 
            // Move left in a[]
            else if (l1 > r2) {
                high = mid1 - 1;
            } 
            // Move right in a[]
            else {
                low = mid1 + 1;
            }
        }

        return -1;
    }
}
