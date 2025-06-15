package BinarySearchTrees;

// Define the Node structure for BST
class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class Kthsmallest {
    int count = 0;   // Tracks number of visited nodes
    int ans = -1;    // Stores the kth smallest value

    // Main method for testing
    public static void main(String[] args) {
        Kthsmallest obj = new Kthsmallest();

        // Sample BST: [5,3,6,2,4,null,null,1]
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.left = new Node(1);

        int k = 3;
        int result = obj.kthsmallest(root, k);
        System.out.println("Kth Smallest Element = " + result);  // Output: 3
    }

    // Wrapper method to start DFS
    public int kthsmallest(Node root, int k) {
        count = 0;
        ans = -1;
        inorder(root, k);
        return ans;
    }

    // In-order traversal to find kth smallest
    public void inorder(Node node, int k) {
        if (node == null) return;

        inorder(node.left, k);  // Left subtree

        count++;                // Visit node
        if (count == k) {
            ans = node.val;
            return;             // Early exit
        }

        inorder(node.right, k); // Right subtree
    }
}
