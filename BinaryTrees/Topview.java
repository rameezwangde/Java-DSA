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

public class Topview {

    // Class to hold a node and its horizontal distance
    static class Pair {
        Node node;
        int hd; // horizontal distance

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Function to return a list of nodes visible from the top view
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;

            // Only add the first node encountered at this horizontal distance
            if (!map.containsKey(hd)) {
                map.put(hd, curr.data);
            }

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

        ArrayList<Integer> topViewList = topView(root);
        System.out.println("Top View: " + topViewList);
    }
}
