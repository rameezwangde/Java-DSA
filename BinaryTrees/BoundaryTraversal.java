package BinaryTrees;

import java.util.ArrayList;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BoundaryTraversal {

    public static void main(String[] args) {
        // Sample Binary Tree:
        /*
                   1
                 /   \
                2     3
               / \   / \
              4   5 6   7
                   / \
                  8   9
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);

        BoundaryTraversal bt = new BoundaryTraversal();
        ArrayList<Integer> boundary = bt.boundaryTraversal(root);

        System.out.println("Boundary Traversal: " + boundary);
    }

    ArrayList<Integer> boundaryTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        if (!isLeaf(root)) res.add(root.val); // Add root only if not a leaf

        addLeftBoundary(root, res);
        addLeaves(root, res);
        addRightBoundary(root, res);

        return res;
    }

    private static boolean isLeaf(TreeNode node) {
        return (node.left == null) && (node.right == null);
    }

    private static void addLeftBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) res.add(curr.val);
            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    private static void addLeaves(TreeNode root, ArrayList<Integer> res) {
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }
        if (root.left != null) addLeaves(root.left, res);
        if (root.right != null) addLeaves(root.right, res);
    }

    private static void addRightBoundary(TreeNode root, ArrayList<Integer> res) {
        TreeNode curr = root.right;
        Stack<Integer> st = new Stack<>();
        while (curr != null) {
            if (!isLeaf(curr)) st.push(curr.val);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        while (!st.isEmpty()) {
            res.add(st.pop());
        }
    }
}

