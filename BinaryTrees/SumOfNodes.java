package BinaryTrees;

public class SumOfNodes {
    static class Node{
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = right = null;

        }
    }
    public static void main(String[] args) {
         Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        // Call size function
        int sum = sumOfNodes(root);
        System.out.println("Sum of tree nodes: " + sum);  // Output: 15
    }

    public static int sumOfNodes(Node root){
        if(root == null) return 0;
        return root.data + sumOfNodes(root.left) + sumOfNodes(root.right);
    }
}
