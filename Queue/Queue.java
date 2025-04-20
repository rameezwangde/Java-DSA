package Queue;

public class Queue {
    private int front, rear, size;
    private int capacity;
    private int[] queue;

    // Constructor
    public Queue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue - add element
    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue " + data);
            return;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = data;
        size++;
        System.out.println(data + " enqueued.");
    }

    // Dequeue - remove element
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int data = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println(data + " dequeued.");
        return data;
    }

    // Peek - view front
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing to peek.");
            return -1;
        }
        return queue[front];
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Display the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        System.out.print("Queue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(queue[index] + " ");
        }
        System.out.println();
    }

    // Main method to test
    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.display();

        q.dequeue();
        q.display();

        System.out.println("Peek: " + q.peek());
    }
}

