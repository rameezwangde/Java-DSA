package Stack;

import java.util.Stack;

public class InfixToPostfix {

    public static void main(String[] args) {
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("Postfix: " + infixToPostfix(infix)); // Expected Output: abcd^e-fgh*+^*+i-
    }

    // Function to return precedence of operators
    public static int precedence(char ch) {
        if (ch == '^') return 3;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '+' || ch == '-') return 1;
        return -1;
    }

    // Main function to convert infix to postfix
    public static String infixToPostfix(String s) {
        StringBuilder postfix = new StringBuilder(); // To store result
        Stack<Character> st = new Stack<>();         // Stack for operators

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If character is operand (a-z, A-Z, 0-9), add to output
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }

            // If '(', push to stack
            else if (ch == '(') {
                st.push(ch);
            }

            // If ')', pop and append until '(' is found
            else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    postfix.append(st.pop());
                }
                if (!st.isEmpty()) {
                    st.pop(); // Pop the '('
                }
            }

            // If operator is found
            else {
                while (!st.isEmpty() && precedence(ch) <= precedence(st.peek())) {
                    // For right-associative '^', skip popping if same precedence
                    if (ch == '^' && st.peek() == '^') break;
                    postfix.append(st.pop());
                }
                st.push(ch); // Push current operator
            }
        }

        // Pop any remaining operators from the stack
        while (!st.isEmpty()) {
            postfix.append(st.pop());
        }

        return postfix.toString(); // Return final postfix expression
    }
}

