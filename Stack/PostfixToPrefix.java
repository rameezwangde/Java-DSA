package Stack;

import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        String postfix = "ab+c*";  // Expected prefix: *+abc
        String prefix = postfixToPrefix(postfix);
        System.out.println("Prefix: " + prefix); // Output: *+abc
    }

    // Check if the character is an operator
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Convert postfix to prefix expression
    public static String postfixToPrefix(String s) {
        Stack<String> st = new Stack<>();

        // Traverse from left to right
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If operand, push as string
            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));  // No extra space
            } 
            // If operator, pop 2 operands and combine
            else if (isOperator(ch)) {
                String op2 = st.pop();
                String op1 = st.pop();
                String exp = ch + op1 + op2;  // Prefix: operator followed by operands
                st.push(exp);
            }
        }

        // Final expression
        return st.peek();
    }
}

