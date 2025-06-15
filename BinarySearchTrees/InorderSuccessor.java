package BinarySearchTrees;

class MyNode {
    int data;
    MyNode left, right;

    MyNode(int val) {
        data = val;
        left = right = null;
    }
}

public class InorderSuccessor {
    MyNode pre = null;
    MyNode suc = null;

    public static void main(String[] args) {
        MyNode root = new MyNode(20);
        root.left = new MyNode(10);
        root.right = new MyNode(30);
        root.left.left = new MyNode(5);
        root.right.right = new MyNode(40);

        InorderSuccessor obj = new InorderSuccessor();
        int key = 22;
        MyNode[] result = obj.findPreSuc(root, key);

        System.out.println("Key: " + key);
        System.out.println("Predecessor: " + (result[0] != null ? result[0].data : "None"));
        System.out.println("Successor: " + (result[1] != null ? result[1].data : "None"));
    }

    public MyNode[] findPreSuc(MyNode root, int key) {
        findPredecessor(root, key);
        findSuccessor(root, key);
        return new MyNode[]{pre, suc};
    }

    private void findPredecessor(MyNode root, int key) {
        while (root != null) {
            if (root.data < key) {
                pre = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
    }

    private void findSuccessor(MyNode root, int key) {
        while (root != null) {
            if (root.data > key) {
                suc = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }
}

