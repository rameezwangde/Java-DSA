package BinarySearchTrees;

// Definition of TreeNode class
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Lca {
    public static void main(String[] args) {
        // Sample BST:
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = root.left;          // Node with value 2
        TreeNode q = root.left.right;    // Node with value 4

        TreeNode lcaNode = lca(root, p, q);
        System.out.println("Lowest Common Ancestor: " + lcaNode.val);  // Output: 2
    }

    // Method to find LCA of two nodes in BST
    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        // If both nodes are smaller, go left
        if (p.val < root.val && q.val < root.val) {
            return lca(root.left, p, q);
        }

        // If both nodes are larger, go right
        if (p.val > root.val && q.val > root.val) {
            return lca(root.right, p, q);
        }

        // If they are on different sides or one equals root, root is LCA
        return root;
    }
}

