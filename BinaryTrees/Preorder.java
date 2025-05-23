package BinaryTrees;

public class Preorder {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Recursive preorder traversal method
    public static void preorderTraversal(Node root) {
        if (root == null) return;

        System.out.print(root.data + " "); // Visit root
        preorderTraversal(root.left);      // Traverse left subtree
        preorderTraversal(root.right);     // Traverse right subtree
    }

    public static void main(String[] args) {
        // Constructing the following binary tree:
        //         1
        //       /   \
        //      2     3
        //     / \
        //    4   5

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.print("Preorder Traversal: ");
        preorderTraversal(root); // Output should be: 1 2 4 5 3
    }
}

