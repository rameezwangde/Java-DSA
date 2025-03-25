class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow; // Middle node
    }

    // Helper function to create a linked list from an array
    public static ListNode createList(int[] values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode temp = head;
        for (int i = 1; i < values.length; i++) {
            temp.next = new ListNode(values[i]);
            temp = temp.next;
        }
        return head;
    }

    // Helper function to print a linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample Data
        int[] values = {1, 2, 3, 4, 5}; // Odd-length list
        ListNode head = createList(values);

        System.out.println("Original List:");
        printList(head);

        Solution sol = new Solution();
        ListNode middle = sol.middleNode(head);

        System.out.println("Middle Node Value: " + middle.val);
    }
}

