package Stack;

class StackNode {
    int data;
    StackNode next;

    StackNode(int a) {
        data = a;
        next = null;
    }
}

public class StackasLL {
    static StackNode top = null;
    static int size = 0;

    public static void main(String[] args) {
        push(10);
        push(20);
        System.out.println("Popped: " + pop()); // should return 20
        System.out.println("Popped: " + pop()); // should return 10
        System.out.println("Popped: " + pop()); // should return -1 (empty)
        System.out.println("Stack is empty: " + StackIsEmpty()); // true
        System.out.println("Stack size: " + StackSize()); // 0
    }

    public static void push(int a) {
        StackNode element = new StackNode(a);
        element.next = top;
        top = element;
        size++;
    }

    public static int pop() {
        if (top == null) return -1;
        int topData = top.data;
        top = top.next;
        size--;
        return topData;
    }

    public static int StackSize() {
        return size;
    }

    public static boolean StackIsEmpty() {
        return top == null;
    }
}

