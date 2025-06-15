package BinaryTrees;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val=val;
        this.left=this.right=null;
    }
}
public class Symmetric {
    public static void main(String[] args) {
         // Symmetric Tree:
        //        1
        //       / \
        //      2   2
        //     / \ / \
        //    3  4 4  3

        TreeNode root=new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(2);
        root.left.left=new TreeNode(3);
        root.left.right=new TreeNode(4);
        root.right.left=new TreeNode(4);
        root.right.right=new TreeNode(3);

        boolean res=isSymmetric(root);
        System.out.println(res);

    }

    public static boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left,root.right);
    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if(t1==null && t2==null) return true;
        if(t1==null || t2==null) return false;
        return (t1.val==t2.val) && isMirror(t1.right,t2.left) &&isMirror(t1.left, t2.right);
    }
}
