package BinaryTrees;

public class ChangeTree {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
    }

   public void changeTree(TreeNode root) {
    if (root == null) return;

    // First recurse on children
    changeTree(root.left);
    changeTree(root.right);

    int leftVal = (root.left != null) ? root.left.val : 0;
    int rightVal = (root.right != null) ? root.right.val : 0;
    int childSum = leftVal + rightVal;

    // If root is a leaf, no change needed
    if (root.left == null && root.right == null) return;

    if (childSum >= root.val) {
        root.val = childSum;
    } else {
        // Increase children values to root.val as needed
        if (root.left != null) root.left.val = root.val;
        if (root.right != null) root.right.val = root.val;
    }
}


    public static void main(String[] args) {
        ChangeTree sol = new ChangeTree();

       TreeNode root = new TreeNode(35);
    root.left = new TreeNode(20);
    root.right = new TreeNode(15);

    root.left.left = new TreeNode(15);
    root.left.right = new TreeNode(5);

    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);

sol.changeTree(root);

printInOrder(root);

    }

   public static void printInOrder(TreeNode root) {
    if (root == null) return;
    printInOrder(root.left);
    System.out.print(root.val + " ");
    printInOrder(root.right);
}

}

