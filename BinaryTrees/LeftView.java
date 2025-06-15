package BinaryTrees;

import java.util.*;

public class LeftView {

    // Binary Tree Node class
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Main method
    public static void main(String[] args) {
        /*
               1
             /   \
            2     3
             \   / \
              4 5   6
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.left.left=new Node(10);
        root.right.left = new Node(5);
        root.right.right = new Node(6);

        ArrayList<Integer> leftViewList = leftView(root);
        System.out.println("Left View of the Binary Tree:");
        for (int val : leftViewList) {
            System.out.print(val + " ");
        }
    }

    // Function to return the left view of the binary tree
    public static ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();  // Number of nodes at this level

            for (int i = 0; i < size; i++) {
                Node current = q.poll();

                // Add the first node of each level
                if (i == 0) result.add(current.data);

                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }
        }

        return result;
    }
}

