class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class InsertHead {
    public static void main(String[] args) {
        Node head = new Node(10);
        head = insertHead(head, 5);
        head = insertHead(head, 1);

        printList(head);
    }

    public static Node insertHead(Node head, int v) {
        Node newNode = new Node(v);
        newNode.next = head;
        return newNode; // Return the new head
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

