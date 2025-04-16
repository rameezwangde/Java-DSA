class Node {
    int data;
    Node next, prev;

    Node(int data) {
        this.data = data;
    }
}

class DoublyLinkedList {
    Node head;

    // Function to insert a new node at the end
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    // ✅ Function to delete the tail (last node)
    void deleteTail() {
        if (head == null) return; // Empty list
        if (head.next == null) { // Only one node
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next; // Go to last node
        temp.prev.next = null; // Remove last node
    }

    // Function to print the DLL
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class Deltail {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Sample input
        dll.insert(10);
        dll.insert(20);
        dll.insert(30);
        dll.insert(40);

        System.out.println("Before deleting tail:");
        dll.printList();

        dll.deleteTail(); // Delete last node

        System.out.println("After deleting tail:");
        dll.printList();
    }
}



