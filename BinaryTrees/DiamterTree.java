package BinaryTrees;

// Tree node definition
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class DiamterTree {

    public static void main(String[] args) {
        // Sample tree:
        //         1
        //        / \
        //       2   3
        //      / \     
        //     4   5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int result = diameter(root);
        System.out.println("Diameter of the tree: " + result);
    }

    // Returns the diameter of the binary tree
    public static int diameter(TreeNode root) {
        int[] diameter = new int[1]; // to store result as reference
        height(root, diameter);
        return diameter[0];
    }

    // Helper to calculate height and update diameter
    public static int height(TreeNode root, int[] diameter) {
        if (root == null) return 0;

        int left = height(root.left, diameter);
        int right = height(root.right, diameter);

        diameter[0] = Math.max(diameter[0], left + right); // update diameter

        return 1 + Math.max(left, right); // return height
    }
}

