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

// Helper Pair class
class Pair {
    TreeNode node;
    int num;

    Pair(TreeNode node, int num) {
        this.node = node;
        this.num = num;
    }
}

public class AllTraversalsOneTraversal {

    public static void allTraversals(TreeNode root, List<Integer> preorder, List<Integer> inorder, List<Integer> postorder) {
        Stack<Pair>st=new Stack<>();
        if(root==null)return;
        st.push(new Pair(root,1));
        while(!st.isEmpty()){
            Pair p=st.pop();
            if(p.num==1){
                preorder.add(p.node.val);
                p.num++;
                st.push(p);
                if(p.node.left!=null)st.push(new Pair(p.node.left,1));
            }
            else if(p.num==2){
                inorder.add(p.node.val);
                p.num++;
                st.push(p);
                if(p.node.right!=null)st.push(new Pair(p.node.right,1));
            }else{
                postorder.add(p.node.val);
            }
        }
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

        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        allTraversals(root, preorder, inorder, postorder);

        System.out.println("Preorder Traversal: " + preorder);   // [1, 2, 4, 5, 3]
        System.out.println("Inorder Traversal: " + inorder);     // [4, 2, 5, 1, 3]
        System.out.println("Postorder Traversal: " + postorder); // [4, 5, 2, 3, 1]
    }
}
