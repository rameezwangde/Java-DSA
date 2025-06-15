package BinaryTrees;

import java.util.*;

// TreeNode class
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class IterativeInorder {

    // Static method for iterative inorder traversal
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode node = root;

        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                node = st.pop();
                res.add(node.val);
                node = node.right;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // Build a simple binary tree
        /*
                1
                 \
                  2
                 /
                3
        */
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = inorderTraversal(root);
        System.out.println("Inorder Traversal: " + result); // Output: [1, 3, 2]
    }
}

