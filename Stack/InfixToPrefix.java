package Stack;

import java.util.Stack;

public class InfixToPrefix {

    public static void main(String[] args) {
        String infix = "a+b";
        String prefix = infixToPrefix(infix);
        System.out.println("Prefix: " + prefix); // Expected: -+a*b^-^f+gh-e^cdi
    }

    // Step 1: Reverse the string
    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }

    // Step 2: Swap brackets
    public static String swapBrackets(String s) {
        StringBuilder swapped = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '(') swapped.append(')');
            else if (ch == ')') swapped.append('(');
            else swapped.append(ch);
        }
        return swapped.toString();
    }

    // Operator precedence
    public static int precedence(char ch) {
        if (ch == '^') return 3;
        if (ch == '*' || ch == '/') return 2;
        if (ch == '+' || ch == '-') return 1;
        return -1;
    }

    // Infix to Postfix
    public static String infixToPostfix(String s) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    postfix.append(st.pop());
                }
                if (!st.isEmpty()) st.pop(); // Remove '('
            } else {
                while (!st.isEmpty() && precedence(ch) <= precedence(st.peek())) {
                    if (ch == '^' && st.peek() == '^') break;
                    postfix.append(st.pop());
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            postfix.append(st.pop());
        }

        return postfix.toString();
    }

    // Final: Infix to Prefix using Striver's approach
    public static String infixToPrefix(String infix) {
        String reversed = reverse(infix);
        String swapped = swapBrackets(reversed);
        String postfix = infixToPostfix(swapped);
        String prefix = reverse(postfix);
        return prefix;
    }
}

