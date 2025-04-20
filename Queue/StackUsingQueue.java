package Queue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push element x onto stack (O(n))
    public void push(int x) {
        q2.add(x); // Step 1: Add new element to q2

        // Step 2: Push all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Step 3: Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Removes the element on top of the stack and returns that element (O(1))
    public int pop() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.remove();
    }

    // Get the top element (O(1))
    public int top() {
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return q1.peek();
    }

    // Returns whether the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}

public class StackUsingQueue {
    public static void main(String[] args) {
        MyStack st = new MyStack();

        st.push(10);
        st.push(20);
        st.push(30);

        System.out.println("Top element: " + st.top());     // 30
        System.out.println("Popped: " + st.pop());          // 30
        System.out.println("Top element now: " + st.top()); // 20

        System.out.println("Is stack empty? " + st.isEmpty()); // false

        st.pop();
        st.pop();

        System.out.println("Is stack empty after popping all? " + st.isEmpty()); // true
        System.out.println("Pop on empty: " + st.pop()); // -1 with message
    }
}
