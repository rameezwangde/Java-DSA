package Queue;

class MyQueue {
    int[] arr;
    int front;
    int rear;
    int size;
    int capacity;

    // Constructor
    public MyQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Enqueue
    public boolean enqueue(int x) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return false;
        }
        arr[rear] = x;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    // Dequeue
    public int dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        int val = arr[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    // Peek front
    public int peek() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if full
    public boolean isFull() {
        return size == capacity;
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
        MyQueue q = new MyQueue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.enqueue(60); // Should print "Queue is full"

        System.out.println("Front: " + q.peek()); // Output: 10

        System.out.println("Dequeued: " + q.dequeue()); // Output: 10
        System.out.println("Front after dequeue: " + q.peek()); // Output: 20

        q.enqueue(60); // Should be inserted now

        while (!q.isEmpty()) {
            System.out.println("Dequeued: " + q.dequeue());
        }

        System.out.println("Is queue empty? " + q.isEmpty());
    }
}

