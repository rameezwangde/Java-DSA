package BinarySearchTrees;

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Delete {

    // Function to delete a node with a given key from the BST
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // If the node to delete is the root itself
        if (root.val == key) return helper(root);

        TreeNode curr = root;

        // Traverse to find and delete the node
        while (root != null) {
            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }

        return curr;
    }

    // Handles the deletion cases
    private TreeNode helper(TreeNode node) {
        if (node.left == null) return node.right;
        if (node.right == null) return node.left;

        TreeNode rightSubtree = node.right;
        TreeNode lastRight = findLastRight(node.left);
        lastRight.right = rightSubtree;
        return node.left;
    }

    // Finds the rightmost node in a subtree
    private TreeNode findLastRight(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // In-order traversal for display
    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Main method for testing
    public static void main(String[] args) {
        Delete tree = new Delete();

        // Building sample BST: [5,3,6,2,4,null,7]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.println("Original Tree (In-order):");
        tree.inorder(root);

        int key = 5;
        root = tree.deleteNode(root, key);

        System.out.println("\nTree After Deleting " + key + " (In-order):");
        tree.inorder(root);
    }
}
