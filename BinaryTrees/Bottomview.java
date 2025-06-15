package BinaryTrees;

import java.util.*;

// Tree node definition
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        left = right = null;
    }
}

public class Bottomview {

    // Class to hold a node and its horizontal distance
    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Function to return the bottom view of the binary tree
    static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;

            // Overwrite the value at horizontal distance (hd)
            map.put(hd, curr.data);

            if (curr.left != null) {
                q.offer(new Pair(curr.left, hd - 1));
            }

            if (curr.right != null) {
                q.offer(new Pair(curr.right, hd + 1));
            }
        }

        // Collect values from the TreeMap (sorted by hd)
        for (int val : map.values()) {
            result.add(val);
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        /*
              1
             / \
            2   3
             \   \
              4   5
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(5);

        ArrayList<Integer> bottomViewList = bottomView(root);
        System.out.println("Bottom View: " + bottomViewList);
    }
}

