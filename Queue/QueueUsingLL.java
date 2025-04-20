package Queue;

// Node class representing each element of the queue
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Queue implementation using Linked List
class MyQueue {
    private Node front; // points to front of the queue
    private Node rear;  // points to rear of the queue

    // Constructor
    public MyQueue() {
        front = rear = null;
    }

    // Enqueue operation: Add to rear
    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (rear == null) { // Queue is empty
            front = rear = newNode;
            return;
        }
        rear.next = newNode; // add new node after rear
        rear = newNode;      // update rear
    }

    // Dequeue operation: Remove from front
    public int dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        int val = front.data;
        front = front.next;

        // If queue becomes empty after dequeue
        if (front == null) {
            rear = null;
        }

        return val;
    }

    // Peek front element
    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty");
            return -1;
        }
        return front.data;
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return front == null;
    }
}

public class QueueUsingLL {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front: " + q.peek());         // 10
        System.out.println("Dequeued: " + q.dequeue());   // 10
        System.out.println("Front after dequeue: " + q.peek()); // 20

        q.enqueue(40);

        while (!q.isEmpty()) {
            System.out.println("Dequeued: " + q.dequeue());
        }

        System.out.println("Is queue empty? " + q.isEmpty()); // true
    }
}
