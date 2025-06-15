package BinaryTrees;

import java.util.*;

public class RightView {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    public static void main(String[] args) {
        /*
               1
             /   \
            2     3
           / \   / \
          4   5 6   7
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        ArrayList<Integer> rightViewList = rightView(root);
        System.out.println("Right View (Level Order):");
        for (int val : rightViewList) {
            System.out.print(val + " ");
        }
    }

    // Right View using Level Order Traversal
    public static ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node current = q.poll();

                // Add the last node of each level
                if (i == size - 1) {
                    result.add(current.data);
                }

                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }
        }

        return result;
    }
}
