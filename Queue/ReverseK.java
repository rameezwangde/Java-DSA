package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseK {

    // Method to reverse first K elements of a queue
    public static Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
        Stack<Integer> st = new Stack<>();
        int n = q.size();

        // Step 1: Push first k elements into the stack
        for (int i = 0; i < k; i++) {
            st.push(q.remove());
        }

        // Step 2: Enqueue stack elements back to the queue
        while (!st.isEmpty()) {
            q.add(st.pop());
        }

        // Step 3: Move the remaining elements to the back
        for (int i = 0; i < n - k; i++) {
            q.add(q.remove());
        }

        return q;
    }

    // Main method to test
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        // Add elements to queue
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

        System.out.println("Original Queue: " + q);

        int k = 3;
        Queue<Integer> result = reverseFirstK(q, k);

        System.out.println("Queue after reversing first " + k + " elements: " + result);
    }
}
