package Arrays;

public class TrappingRain {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int result = trap(height);
        System.out.println("Total water trapped: " + result);
    }

    // Function to calculate prefix maximum array
    public static int[] fun1(int[] height) {
        int n = height.length;
        int[] Pmax = new int[n];
        Pmax[0] = height[0]; // First element stays the same

        for (int i = 1; i < n; i++) {
            // Store the max so far from the left
            Pmax[i] = Math.max(height[i], Pmax[i - 1]);
        }
        return Pmax;
    }

    // Function to calculate suffix maximum array
    public static int[] fun2(int[] height) {
        int n = height.length;
        int[] Smax = new int[n];
        Smax[n - 1] = height[n - 1]; // Last element stays the same

        for (int i = n - 2; i >= 0; i--) {
            // Store the max so far from the right
            Smax[i] = Math.max(height[i], Smax[i + 1]);
        }
        return Smax;
    }

    // Function to compute total trapped rainwater
    public static int trap(int[] height) {
        int n = height.length;

        // Edge case: if less than 3 bars, no water can be trapped
        if (n < 3) return 0;

        // Get prefix and suffix max arrays
        int[] Pmax = fun1(height);
        int[] Smax = fun2(height);

        int totalWater = 0;

        // Traverse from 1 to n-2 (ignore boundaries)
        for (int i = 1; i < n - 1; i++) {
            int leftBound = Pmax[i - 1];      // Tallest bar on the left
            int rightBound = Smax[i + 1];     // Tallest bar on the right
            int waterLevel = Math.min(leftBound, rightBound); // Water level is limited by shorter side

            int contribution = waterLevel - height[i]; // Potential water at current bar

            if (contribution > 0) {
                totalWater += contribution; // Add if there's space for water
            }
        }

        return totalWater;
    }
}

