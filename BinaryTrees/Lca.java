package BinaryTrees;

public class Lca {
    // Inner TreeNode class (make it static so it can be accessed from main)
    public static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int x) {
            val = x;
        }
    }

    // LCA method
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) return root;
        return root;
    }

    // Main method to test the code
    public static void main(String[] args) {
        // Create tree nodes
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        // Choose nodes to find LCA
        TreeNode p = root.left;      // Node 5
        TreeNode q = root.right;     // Node 1

        // Create instance of Lca to call non-static method
        Lca obj = new Lca();
        TreeNode lca = obj.lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor: " + lca.val);
    }
}

