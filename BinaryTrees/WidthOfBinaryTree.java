package BinaryTrees;

import java.util.*;

// Definition of TreeNode used to build the binary tree
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

// Custom Pair class to associate a TreeNode with its horizontal index
class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

// Main class to compute the maximum width of a binary tree
public class WidthOfBinaryTree {

    // Function to calculate the maximum width of the binary tree
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0; // Empty tree edge case

        int ans = 0; // To store the final maximum width
        Queue<Pair> q = new LinkedList<>(); // Queue for level order traversal
        q.offer(new Pair(root, 0)); // Start with root at index 0

        // Level-order traversal
        while (!q.isEmpty()) {
            int size = q.size(); // Number of nodes in current level
            int min = q.peek().num; // Minimum index at this level (to normalize indices)
            int first = 0, last = 0; // To record the first and last node positions

            for (int i = 0; i < size; i++) {
                int currId = q.peek().num - min; // Normalize the current index
                TreeNode node = q.peek().node;
                q.poll();

                // Update first and last position for the level
                if (i == 0) first = currId;
                if (i == size - 1) last = currId;

                // Enqueue left and right children with proper indices
                if (node.left != null)
                    q.offer(new Pair(node.left, currId * 2 + 1));
                if (node.right != null)
                    q.offer(new Pair(node.right, currId * 2 + 2));
            }

            // Update max width for the current level
            ans = Math.max(ans, last - first + 1);
        }

        return ans; // Final maximum width
    }

    // Main method to test the function with a sample binary tree
    public static void main(String[] args) {
        // Constructing the binary tree:
        //         1
        //       /   \
        //      3     2
        //     / \     \
        //    5   3     9
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        WidthOfBinaryTree sol = new WidthOfBinaryTree();
        int maxWidth = sol.widthOfBinaryTree(root); // Calculate width

        // Output the result
        System.out.println("Maximum width of the binary tree is: " + maxWidth);
    }
}



