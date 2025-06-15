package BinarySearchTrees;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Insert {
    public static void main(String[] args) {
        TreeNode root = null;

        // Insert nodes into the BST
        root = insert(root, 8);
        root = insert(root, 3);
        root = insert(root, 10);
        root = insert(root, 1);
        root = insert(root, 6);
        root = insert(root, 14);
        root = insert(root, 4);
        root = insert(root, 7);

        // Print the tree (In-order Traversal)
        System.out.print("BST: ");
        inOrderTraversal(root);
    }

    // Iterative insert method
    public static TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        TreeNode curr = root;
        while (curr != null) {
            if (val < curr.val) {
                if (curr.left != null) {
                    curr = curr.left;
                } else {
                    curr.left = new TreeNode(val);
                    break;
                }
            } else {
                if (curr.right != null) {
                    curr = curr.right;
                } else {
                    curr.right = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }

    // Helper function for in-order traversal
    public static void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }
}
