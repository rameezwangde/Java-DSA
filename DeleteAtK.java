
class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class DeleteAtK {
    public static void main(String[] args) {
        // Example to test removeK method
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        
        // Print original list
        printList(head);
        
        // Remove node at position 2
        head = removeK(head, 2);
        
        // Print modified list
        printList(head);
    }

    private static Node removeK(Node head, int k) {
        if (head == null || k <= 0) {
            return head;  // No operation if the list is empty or invalid k
        }

        // If removing the head node (k = 1)
        if (k == 1) {
            return head.next;
        }

        Node temp = head;
        int count = 1;

        // Traverse the list to find the (k-1)th node
        while (temp != null && count < k - 1) {
            temp = temp.next;
            count++;
        }

        // If we found the (k-1)th node and (k)th node exists, remove it
        if (temp != null && temp.next != null) {
            temp.next = temp.next.next;
        }

        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
