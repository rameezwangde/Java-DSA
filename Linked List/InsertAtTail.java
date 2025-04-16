class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertAtTail {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtTail(head, 10);
        head = insertAtTail(head, 20);
        head = insertAtTail(head, 30);

        printList(head);
    }

    public static Node insertAtTail(Node head, int v) {
        Node newNode = new Node(v);
        if (head == null) {
            return newNode; // If list is empty, newNode becomes the head
        }

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

        return head; // Return the unchanged head reference
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
