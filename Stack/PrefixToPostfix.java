package Stack;

import java.util.Stack;

public class PrefixToPostfix {
    public static void main(String[] args) {
        String prefix = "*+ab-cd"; // Expected postfix: ab+cd-*
        String postfix = prefixToPostfix(prefix);
        System.out.println("Postfix: " + postfix);
    }

    // Utility to check if a character is an operator
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Function to convert prefix to postfix
    public static String prefixToPostfix(String s) {
        Stack<String> st = new Stack<>();

        // Traverse from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            // If operand, push as string
            if (Character.isLetterOrDigit(ch)) {
                st.push(String.valueOf(ch));
            } 
            // If operator, pop two operands and combine
            else if (isOperator(ch)) {
                String op1 = st.pop();
                String op2 = st.pop();
                String exp = op1 + op2 + ch; // Postfix: operand1 + operand2 + operator
                st.push(exp);
            }
        }

        // Final postfix expression
        return st.peek();
    }
}
