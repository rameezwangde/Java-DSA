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

public class IterativePostOrder1stack {

    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer>res=new ArrayList<>();
       Stack<TreeNode>st=new Stack<>();
       TreeNode curr=root;

       while(curr!=null ||!st.isEmpty()){
        if(curr!=null){
            st.push(curr);
            curr=curr.left;
        }else{
            TreeNode temp=st.peek().right;
            if(temp==null){
                temp=st.pop();
                res.add(temp.val);
                while(!st.isEmpty() && temp==st.peek().right ){
                    temp=st.pop();
                    res.add(temp.val);
                }

            }else{
                curr=temp;
            }
        }
       }
       return res;
        
    }

    public static void main(String[] args) {
        // Build a binary tree
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

        List<Integer> result = postorderTraversal(root);
        System.out.println("Postorder Traversal (1 Stack, Striver's way): " + result); // Output: [4, 5, 2, 3, 1]
    }
}

