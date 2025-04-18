package Stack;

public class StackUsingArray {
    int top;           // Index of the top element
    int[] stack;       // Array to store stack elements
    int size;          // Maximum size of stack

    // Constructor to initialize stack
    StackUsingArray(int size) {
        this.size = size;
        this.stack = new int[size];
        this.top = -1; // Stack is initially empty
    }

    // Push operation
    public void push(int x) {
        if (top == size - 1) {
            System.out.println("Stack Overflow! Cannot push " + x);
            return;
        }
        top++;
        stack[top] = x;
    }

    // Pop operation
    public int pop() {
        if (top == -1) {
            System.out.println("Stack Underflow! Nothing to pop.");
            return -1;
        }
        int popped = stack[top];
        top--;
        return popped;
    }

    // Peek operation (returns top element without removing it)
    public int peek() {
        if (top == -1) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return stack[top];
    }

    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Check if stack is full
    public boolean isFull() {
        return top == size - 1;
    }

    // Print stack
    public void printStack() {
        System.out.print("Stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    // Main to test
    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack(); // Stack: 10 20 30

        System.out.println("Top element: " + stack.peek()); // 30

        stack.pop();
        stack.printStack(); // Stack: 10 20

        System.out.println("Is stack empty? " + stack.isEmpty()); // false
        System.out.println("Is stack full? " + stack.isFull());   // false
    }
}

