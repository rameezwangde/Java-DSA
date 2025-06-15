package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    static class Node{
        int data;
        Node left, right;
        public Node(int data) {
            this.data=data;
            left = right = null;
        }
    }
    public static void main(String[] args) {
         // Constructing a sample tree
        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
        */
        Node root=new Node(1);
        root.left=new Node(2);
        root.right=new Node(3);
        root.left.left=new Node(4);
        root.left.right=new Node(5);
        root.right.left=new Node(6);
        root.right.right=new Node(7);

        List<List<Integer>> result=levelOrderTraversal(root);
        System.out.println("Level prder traversal:");
        for(List<Integer>level:result){
            System.out.println(level);
        }
    }
    public static List<List<Integer>> levelOrderTraversal(Node root){
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;

        Queue<Node>q=new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size=q.size();
            List<Integer>level=new ArrayList<>();
            for(int i=0;i<size;i++){
                Node current=q.poll();
                level.add(current.data);
                if(current.left!=null) q.offer(current.left);
                if(current.right!=null) q.offer(current.right);
            }
            result.add(level);
        }
        return result;
    }

}
