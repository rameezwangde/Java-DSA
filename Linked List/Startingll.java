// Definition for a singly-linked list node
class ListNode {
    int val;
    ListNode next;
    
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Startingll {
    public static void main(String[] args) {
        // Creating a cycle in the linked list
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creating a cycle at node with value 2

        Solution solution = new Solution();  // Correct way to instantiate Solution
        ListNode cycleStart = solution.detectCycle(head); // Correct method call

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected.");
        }
    }
}

// Correct Solution class
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Detect if a cycle exists using Floyd's algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            
            if (slow == fast) { // Cycle detected
                slow = head; // Reset slow to head
                
                // Step 2: Find the start of the cycle
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow; // Start of the cycle
            }
        }
        return null; // No cycle found
    }

    public boolean isPalindrome(ListNode head) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isPalindrome'");
    }
}

