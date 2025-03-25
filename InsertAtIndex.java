class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAtIndex {
    public static void main(String[] args) {
        Node head = null;

        // Sample Data
        head = insertAtIndex(head, 0, 10); // Insert at head
        head = insertAtIndex(head, 1, 20); // Insert at index 1
        head = insertAtIndex(head, 2, 30); // Insert at index 2
        head = insertAtIndex(head, 1, 15); // Insert at index 1

        // Insert a new element at a specific index
        int k = 2; // Index where to insert
        int value = 25; // Value to insert
        head = insertAtIndex(head, k, value);

        printList(head);
    }

    public static Node insertAtIndex(Node head, int k, int v) {
        Node newNode = new Node(v);

        // If inserting at the head (index 0)
        if (k == 0) {
            newNode.next = head;
            return newNode; // New node becomes the head
        }

        Node temp = head;
        for (int i = 0; i < k - 1; i++) {
            if (temp == null) {
                System.out.println("Index out of bounds");
                return head; // Return unchanged list
            }
            temp = temp.next;
        }

        // If temp is null, the index is out of bounds
        if (temp == null) {
            System.out.println("Index out of bounds");
            return head;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        return head;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

