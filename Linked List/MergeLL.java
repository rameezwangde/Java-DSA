public class MergeLL {
    public static void main(String[] args) {
        // Creating first sorted linked list: 1 -> 3 -> 5
        ListNode list1 = new ListNode(1, new ListNode(3, new ListNode(5)));

        // Creating second sorted linked list: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2, new ListNode(4, new ListNode(6)));

        // Merging both lists
        MergeLL obj = new MergeLL();
        ListNode mergedList = obj.mergeTwoLists(list1, list2);

        // Printing the merged linked list
        printList(mergedList); // Expected output: 1 -> 2 -> 3 -> 4 -> 5 -> 6
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) { 
        ListNode dummy = new ListNode(0); // Dummy node
        ListNode temp = dummy; 
        
        while (l1 != null && l2 != null) { 
            if (l1.val < l2.val) { 
                dummy.next = l1; 
                l1 = l1.next; 
            } else { 
                dummy.next = l2; 
                l2 = l2.next; 
            } 
            dummy = dummy.next;
        }
        
        // Attach remaining nodes
        if (l1 != null) { 
            dummy.next = l1; 
        } else { 
            dummy.next = l2; 
        }
        
        return temp.next; // Returning the merged list starting from temp.next
    }

    // Helper function to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    
    ListNode() {} // Default constructor
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

