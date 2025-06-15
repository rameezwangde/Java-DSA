package BinaryTrees;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class RootToNodePath {

    // Function to find the path from root to target node
    public static boolean getPath(TreeNode root, List<Integer> path, int target) {
        if (root == null) return false;

        // Step 1: Add current node to path
        path.add(root.val);

        // Step 2: Check if it's the target node
        if (root.val == target) return true;

        // Step 3: Recurse into left and right subtrees
        if (getPath(root.left, path, target) || getPath(root.right, path, target)) {
            return true;
        }

        // Step 4: Backtrack
        path.remove(path.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        /*
                  1
                 / \
                2   3
               / \
              4   5
        */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int target = 5;
        List<Integer> path = new ArrayList<>();

        boolean found = getPath(root, path, target);

        if (found) {
            System.out.println("Path to node " + target + ": " + path);
        } else {
            System.out.println("Node not found.");
        }
    }
}

