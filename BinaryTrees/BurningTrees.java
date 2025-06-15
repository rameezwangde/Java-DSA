package BinaryTrees;

import java.util.*;

public class BurningTrees {

    // Node class for binary tree
    static class Node {
        int data;
        Node left, right;
        Node(int val) {
            data = val;
            left = null;
            right = null;
        }
    }

    public static class Solution {

        // Step 1: Map all child nodes to their parent
        private static void mapParents(Node root, Map<Node, Node> parentMap) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            while (!q.isEmpty()) {
                Node curr = q.poll();

                if (curr.left != null) {
                    parentMap.put(curr.left, curr);
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    parentMap.put(curr.right, curr);
                    q.add(curr.right);
                }
            }
        }

        // Step 2: Find the target node in the tree
        private static Node findTarget(Node root, int target) {
            if (root == null) return null;
            if (root.data == target) return root;

            Node left = findTarget(root.left, target);
            if (left != null) return left;

            return findTarget(root.right, target);
        }

        // Step 3: Use BFS to simulate the burning process
        public static int minTime(Node root, int target) {
            Map<Node, Node> parentMap = new HashMap<>();
            mapParents(root, parentMap);

            Node targetNode = findTarget(root, target);
            if (targetNode == null) return 0;

            Queue<Node> q = new LinkedList<>();
            Set<Node> visited = new HashSet<>();

            q.add(targetNode);
            visited.add(targetNode);

            int time = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                boolean burned = false;

                for (int i = 0; i < size; i++) {
                    Node curr = q.poll();

                    if (curr.left != null && !visited.contains(curr.left)) {
                        q.add(curr.left);
                        visited.add(curr.left);
                        burned = true;
                    }

                    if (curr.right != null && !visited.contains(curr.right)) {
                        q.add(curr.right);
                        visited.add(curr.right);
                        burned = true;
                    }

                    Node parent = parentMap.get(curr);
                    if (parent != null && !visited.contains(parent)) {
                        q.add(parent);
                        visited.add(parent);
                        burned = true;
                    }
                }

                if (burned) time++;
            }

            return time;
        }
    }

    // Optional: You can add a main method to test the code
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.left.right.left = new Node(7);
        root.left.right.right = new Node(8);

        int target = 5;
        int result = Solution.minTime(root, target);
        System.out.println("Minimum time to burn the tree: " + result);
    }
}

