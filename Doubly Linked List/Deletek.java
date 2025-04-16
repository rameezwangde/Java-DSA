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

    // Function to delete head (first node)
    void deleteHead() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    // Function to delete the tail (last node)
    void deleteTail() {
        if (head == null) return;
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next; // Go to last node
        temp.prev.next = null; // Remove last node
    }

    // ✅ Function to delete the kth node from the end
    void deleteKthFromEnd(int k) {
        if (head == null) return;

        Node temp = head;
        int count = 0;

        // Find the length of the DLL
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // If k is greater than the size of DLL
        if (k > count || k <= 0) {
            System.out.println("Invalid k: greater than list size or negative");
            return;
        }

        // Find the (count - k)th node from start
        int target = count - k;
        temp = head;

        // If deleting the head
        if (target == 0) {
            deleteHead();
            return;
        }

        // Traverse to the node to be deleted
        for (int i = 0; i < target; i++) {
            temp = temp.next;
        }

        // If deleting the tail
        if (temp.next == null) {
            deleteTail();
            return;
        }

        // Deleting the node in the middle
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
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

public class Deletek {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();

        // Sample input
        dll.insert(10);
        dll.insert(20);
        dll.insert(30);
        dll.insert(40);
        dll.insert(50);

        System.out.println("Before deleting kth node:");
        dll.printList();

        int k = 2; // Example: Delete 2nd node from end
        dll.deleteKthFromEnd(k);

        System.out.println("After deleting " + k + "th node from end:");
        dll.printList();
    }
}



