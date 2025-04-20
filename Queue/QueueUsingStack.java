package Queue;

import java.util.Stack;

class MyQueue {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    // Enqueue (push) - O(1)
    public void enqueue(int x) {
        inStack.push(x);
    }

    // Shift elements from inStack to outStack only when needed
    private void shiftStacks() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
    }

    // Dequeue (pop) - Amortized O(1)
    public int dequeue() {
        shiftStacks();
        if (outStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return outStack.pop();
    }

    // Peek front - Amortized O(1)
    public int peek() {
        shiftStacks();
        if (outStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return outStack.peek();
    }

    // Check if empty
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front: " + q.peek());    // 10
        System.out.println("Dequeued: " + q.dequeue()); // 10
        System.out.println("Front after dequeue: " + q.peek()); // 20

        q.enqueue(40);

        while (!q.isEmpty()) {
            System.out.println("Dequeued: " + q.dequeue());
        }

        System.out.println("Is queue empty? " + q.isEmpty()); // true
        System.out.println("Try to dequeue again: " + q.dequeue()); // -1
    }
}

