// Definition for singly-linked list node
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class PalindromeLL {
    // Function to reverse a linked list
    public ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    // Function to check if the linked list is a palindrome
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        // Find the middle of the list using slow & fast pointers
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        ListNode newHead = reverse(slow.next);
        ListNode first = head;
        ListNode second = newHead;

        // Compare both halves
        boolean isPalindrome = true;
        while (second != null) {
            if (first.val != second.val) {
                isPalindrome = false;
                break;
            }
            first = first.next;
            second = second.next;
        }

        // Restore the original list (re-reverse the second half)
        slow.next = reverse(newHead);

        return isPalindrome;
    }

    // Main function to test in VS Code
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Creating a linked list: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        // Check if it's a palindrome
        boolean result = solution.isPalindrome(head);
        System.out.println("Is the linked list a palindrome? " + result);
    }
}

