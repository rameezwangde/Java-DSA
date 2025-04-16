class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertElement {
    public static void main(String[] args) {
        // Step 1: Create the linked list with sample data
        Node head = null;
        head = insertAtTail(head, 10);
        head = insertAtTail(head, 20);
        head = insertAtTail(head, 30);
        head = insertAtTail(head, 40);
        head = insertAtTail(head, 50);

        // Step 2: Print the original list
        System.out.println("Original List:");
        printList(head);

        // Step 3: Insert before a specific value
        int targetValue = 30; // Value before which we insert
        int newValue = 25; // Value to be inserted
        head = insertBeforeValue(head, targetValue, newValue);

        // Step 4: Print the modified list
        System.out.println("List after inserting " + newValue + " before " + targetValue + ":");
        printList(head);
    }

    // Function to insert a node at the tail of the list
    public static Node insertAtTail(Node head, int v) {
        Node newNode = new Node(v);
        if (head == null) {
            return newNode;
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

        return head;
    }

    // Function to insert a new node before a given value
    public static Node insertBeforeValue(Node head, int target, int value) {
        Node newNode = new Node(value);

        // Case 1: If the list is empty
        if (head == null) {
            System.out.println("List is empty, cannot insert before " + target);
            return head;
        }

        // Case 2: If the target is at the head
        if (head.data == target) {
            newNode.next = head;
            return newNode; // New node becomes the head
        }

        // Case 3: Search for the target and insert before it
        Node temp = head;
        while (temp.next != null && temp.next.data != target) {
            temp = temp.next;
        }

        // If target value was not found
        if (temp.next == null) {
            System.out.println("Value " + target + " not found in the list.");
            return head;
        }

        // Insert the new node before the target
        newNode.next = temp.next;
        temp.next = newNode;

        return head;
    }

    // Function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

