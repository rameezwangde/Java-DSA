package BinaryTrees;

public class Postorder {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;

        }
    }
    public static void postorder(Node root) {
        if(root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }
    public static void main(String[] args) {
        // Tree:
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

        System.out.print("Postorder Traversal: ");
        postorder(root); // Output: 4 5 2 3 1
    }
}
