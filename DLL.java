class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class Solution {
    Node constructDLL(int arr[]) {
        if (arr == null || arr.length == 0) return null; // Edge case check
        
        Node head = new Node(arr[0]);
        Node prev = head;
        
        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            prev.next = temp;
            temp.prev = prev; // Linking previous node
            prev = temp;
        }
        
        return head; // Return the head of the DLL
    }
}

public class DLL {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50}; // Sample array
        
        Solution solution = new Solution();
        Node head = solution.constructDLL(arr);
        
        System.out.println("Doubly Linked List in Forward Direction:");
        printForward(head);
        
        System.out.println("\nDoubly Linked List in Reverse Direction:");
        printReverse(head);
    }

    // Function to print the DLL in forward direction
    static void printForward(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            if (temp.next == null) {
                break; // Save the last node to use for reverse printing
            }
            temp = temp.next;
        }
    }

    // Function to print the DLL in reverse direction
    static void printReverse(Node tail) {
        // Move to the last node
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
        
        // Print in reverse
        while (tail != null) {
            System.out.print(tail.data + " ");
            tail = tail.prev;
        }
    }
}

