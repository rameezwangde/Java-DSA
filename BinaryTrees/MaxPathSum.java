package BinaryTrees;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class MaxPathSum {
    public static void main(String[] args) {
        // Test tree:
        //       -10
        //       /  \
        //      9   20
        //          / \
        //         15  7

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println("Max Path Sum: " + maxPathSum(root)); // Output: 42
    }

   

    public static int maxPathSum(TreeNode root) {
      int maxvalue[]=new int[1];
      maxvalue[0]=Integer.MIN_VALUE;
      maxGain(root,maxvalue);
      return maxvalue[0];

    }

    private static int maxGain(TreeNode root,int maxvalue[]) {
       if(root==null)return 0;
        int left=Math.max(0,maxGain(root.left,maxvalue));
        int right=Math.max(0,maxGain(root.right,maxvalue));

        maxvalue[0]=Math.max(maxvalue[0],left+right+root.val);
        return Math.max(0,Math.max(left,right)+root.val);
    }
}

