class Node {
    int data;
    Node next;
    
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Deletetail {
    public static void main(String[] args) {
        // Example to test the deleteTail method
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        
        // Print original list
        printList(head);
        
        // Delete the tail node
        head = deleteTail(head);
        
        // Print modified list
        printList(head);
    }
    
    public static Node deleteTail(Node head) {
        if (head == null || head.next == null) {
            // If list is empty or has only one node, return null or head
            return null;
        }
        
        Node temp = head;
        
        // Traverse until we find the second last node
        while (temp.next != null && temp.next.next != null) {
            temp = temp.next;
        }
        
        // Remove the tail node
        temp.next = null;
        
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

