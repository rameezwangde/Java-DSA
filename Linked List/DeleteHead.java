class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteHead {
    public static Node deleteNode(Node head) {
        if (head == null) {
            return null; // If list is empty, return null
        }
        return head.next; // Move head to next node
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample linked list: 1 -> 2 -> 3 -> null
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);

        System.out.println("Original List:");
        printList(head);

        // Delete the head node
        head = deleteNode(head);

        System.out.println("After Deleting Head:");
        printList(head);
    }
}
