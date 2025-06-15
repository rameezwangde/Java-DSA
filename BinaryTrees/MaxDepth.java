package BinaryTrees;
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class MaxDepth {
    public static void main(String[] args) {
         // Build a simple binary tree
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

        int res=maxDepth(root);
        System.out.println("Max Depth: " + res);
    }
    public static int maxDepth(TreeNode root) {
        if(root==null) return 0;

        int left=maxDepth(root.left);
        int right=maxDepth(root.right);

        return 1 +Math.max(left,right);
    }

}
