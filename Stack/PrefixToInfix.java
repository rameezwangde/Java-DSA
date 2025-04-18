package Stack;

import java.util.Stack;

public class PrefixToInfix {
    public static void main(String[] args) {
        String prefix = "*+pq-mn"; // Example: equivalent to ((p + q) * (m - n))
        String infix = prefixToInfix(prefix);
        System.out.println("Infix: " + infix); // Output: ((p + q) * (m - n))
    }

    // Utility method to check if a character is an operator
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Method to convert prefix expression to infix
    public static String prefixToInfix(String s) {
        Stack<String> st = new Stack<>();

        // Traverse the prefix expression from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            // If the character is an operand (letter or digit), push it to the stack
            if (Character.isLetterOrDigit(ch)) {
                st.push(ch + "");  // Convert char to string before pushing
            }
            // If the character is an operator
            else if (isOperator(ch)) {
                // Pop two operands from the stack
                String op1 = st.pop(); // First operand (left)
                String op2 = st.pop(); // Second operand (right)

                // Combine them in infix format with parentheses
                String exp = "(" + op1 + " " + ch + " " + op2 + ")";

                // Push the resulting expression back onto the stack
                st.push(exp);
            }
        }

        // Final expression in the stack is the complete infix expression
        return st.peek();
    }
}

