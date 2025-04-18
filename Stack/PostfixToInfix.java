package Stack;

import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        String postfix = "ab-de+f*/";
        String infix = postfixToInfix(postfix);
        System.out.println("Infix: " + infix); // Output: ((a - b) / ((d + e) * f))
    }

    // Utility function to check if a character is an operator
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }

    // Function to convert postfix expression to infix
    public static String postfixToInfix(String s) {
        Stack<String> st = new Stack<>();

        // Traverse the postfix expression from left to right
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If the character is an operand (letter or digit), push it to the stack
            if (Character.isLetterOrDigit(ch)) {
                st.push(ch + ""); // Convert char to string and push
            } 
            // If the character is an operator
            else if (isOperator(ch)) {
                // Pop two operands from the stack
                String operand2 = st.pop(); // Right operand
                String operand1 = st.pop(); // Left operand

                // Combine them into an infix expression with parentheses
                String exp = "(" + operand1 + " " + ch + " " + operand2 + ")";

                // Push the resulting sub-expression back to the stack
                st.push(exp);
            }
        }

        // Final element of the stack is the fully parenthesized infix expression
        return st.peek();
    }
}

