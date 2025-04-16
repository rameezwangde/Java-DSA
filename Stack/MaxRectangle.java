package Stack;

import java.util.Stack;

public class MaxRectangle {
    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };

        MaxRectangle obj = new MaxRectangle();
        int area = obj.maximalRectangle(matrix);
        System.out.println("Maximum Rectangle Area: " + area);
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxArea = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols + 1]; // extra element to handle stack flush

        for (char[] row : matrix) {
            // Build the histogram for this row
            for (int i = 0; i < cols; i++) {
                if (row[i] == '1') {
                    heights[i] += 1;
                } else {
                    heights[i] = 0;
                }
            }

            // Calculate max area in this histogram
            Stack<Integer> st = new Stack<>();
            for (int i = 0; i < heights.length; i++) {
                while (!st.isEmpty() && heights[i] < heights[st.peek()]) {
                    int h = heights[st.pop()];
                    int w;
                    if (st.isEmpty()) {
                        w = i;
                    } else {
                        w = i - st.peek() - 1;
                    }
                    int area = h * w;
                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
                st.push(i);
            }
        }

        return maxArea;
    }
}

