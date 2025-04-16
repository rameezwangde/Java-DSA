package Stack;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minst;

    public MinStack() {
        st = new Stack<>();
        minst = new Stack<>();
    }

    public void push(int val) {
        st.push(val);
        if (minst.isEmpty() || val <= minst.peek()) {
            minst.push(val);
        }
    }

    public void pop() {
        int temp = st.pop();
        if (temp == minst.peek()) {
            minst.pop();
        }
    }

    public int top() {
        return st.peek();
    }

    public int getMin() {
        return minst.peek();
    }

    // Main method to test functionality
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(5);
        System.out.println("Min: " + minStack.getMin()); // 3
        minStack.push(2);
        minStack.push(1);
        System.out.println("Min: " + minStack.getMin()); // 1
        minStack.pop();
        System.out.println("Min: " + minStack.getMin()); // 2
        System.out.println("Top: " + minStack.top());    // 2
    }
}

