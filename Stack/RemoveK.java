package Stack;

import java.util.Stack;

public class RemoveK {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKDigits(num, k));  // Output: "1219"
    }

    public static String removeKDigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);

            while (!st.isEmpty() && k > 0 && st.peek() > digit) {
                st.pop();
                k--;
            }

            st.push(digit);
        }

        // Remove any remaining digits from the end if k > 0
        while (k > 0 && !st.isEmpty()) {
            st.pop();
            k--;
        }

        // Build the result from stack
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        sb.reverse();

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // Return result
        if (sb.length() == 0) {
            return "0";
        } else {
            return sb.toString();
        }
    }
}


