package BinaryTrees;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class SumRootToLeaf {
    public static void main(String[] args) {
        // Example Tree:
        //     1
        //    / \
        //   2   3
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        int result = sumNumbers(root);
        System.out.println("Sum of Root to Leaf Numbers: " + result);  // Output: 25 (12 + 13)
    }

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode root, int currentSum) {
        if (root == null) return 0;

        currentSum = currentSum * 10 + root.val;

        // If it's a leaf node, return the currentSum
        if (root.left == null && root.right == null) {
            return currentSum;
        }

        // Recurse left and right
        int leftSum = dfs(root.left, currentSum);
        int rightSum = dfs(root.right, currentSum);

        return leftSum + rightSum;
    }
}

