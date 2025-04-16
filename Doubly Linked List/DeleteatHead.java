class Node {
    int data;
    Node next;
    Node prev; // Renamed 'back' to 'prev' for standard DLL convention

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    Node head;

    // Function to construct DLL from array
    void constructDLL(int arr[]) {
        if (arr.length == 0) return;

        head = new Node(arr[0]);
        Node prev = head;
        
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.prev = prev; // Corrected to 'prev' instead of 'back'
            prev = temp;
        }
    }

    // Function to delete the head node
    void deleteHead() {
        if (head == null) {
            System.out.println("DLL is empty, nothing to delete.");
            return;
        }

        Node prev = head; // Store the current head
        head = head.next; // Move head to the next node

        if (head != null) { 
            head.prev = null; // New head should not have a previous node
        }

        prev.next = null; // Detach old head
    }

    // Function to print the DLL
    void printDLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class DeleteatHead {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50}; // Sample input

        DoublyLinkedList dll = new DoublyLinkedList();
        dll.constructDLL(arr);

        System.out.println("Original Doubly Linked List:");
        dll.printDLL();

        // Deleting the head
        dll.deleteHead();

        System.out.println("After Deleting Head:");
        dll.printDLL();
    }
}

