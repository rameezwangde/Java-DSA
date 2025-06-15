package BinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class Pathsum2 {

    // Static inner class for TreeNode
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        // Build example tree: [5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        Pathsum2 obj = new Pathsum2();
        List<List<Integer>> paths = obj.pathSum(root, targetSum);

        System.out.println("Paths that sum to " + targetSum + ":");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        List<Integer> path = new ArrayList<>();
        dfs(root, targetSum, path, res);
        return res;
    }

    // Use void instead of int
    public static void dfs(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> res) {
        if (node == null) return;

        path.add(node.val);

        if (node.left == null && node.right == null && node.val == targetSum) {
            res.add(new ArrayList<>(path));
        }

        dfs(node.left, targetSum - node.val, path, res);
        dfs(node.right, targetSum - node.val, path, res);

        path.remove(path.size() - 1); // Backtrack
    }
}

