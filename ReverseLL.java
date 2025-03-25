class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class ReverseLL {
    public ListNode reverseList(ListNode head) {
        // Base case: If the list is empty or only one node, return head
        if (head == null || head.next == null) {
            return head;
        }

        // Recursively reverse the rest of the list
        ListNode newHead = reverseList(head.next);

        // Adjust pointers to reverse the current node
        head.next.next = head;
        head.next = null;

        return newHead;
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
        int[] values = {1, 2, 3, 4, 5};
        ListNode head = createList(values);

        System.out.println("Original List:");
        printList(head);

        ReverseLL sol = new ReverseLL();
        ListNode reversedHead = sol.reverseList(head);

        System.out.println("Reversed List:");
        printList(reversedHead);
    }
}

