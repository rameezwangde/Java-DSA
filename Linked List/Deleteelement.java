class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Deleteelement {
    public static void main(String[] args) {
        // Example to test removeel method
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        
        // Print original list
        printList(head);
        
        // Remove element with value 3
        head = removeel(head, 2);
        
        // Print modified list
        printList(head);
    }

    private static Node removeel(Node head, int el) {
        if (head == null) {
            return head;  // No operation if the list is empty
        }

        // If removing the head node (head.data == el)
        if (head.data == el) {
            return head.next;  // Skip the head node
        }

        Node temp = head;
        Node prev = null;

        // Traverse the list to find the element to delete
        while (temp != null) {
            if (temp.data == el) {
                prev.next = temp.next;  // Remove the node
                return head;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;  // Return the unchanged head if the element wasn't found
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
