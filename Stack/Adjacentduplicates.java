package Stack;

import java.util.Stack;

public class Adjacentduplicates {
    public static void main(String[] args) {
        String input = "abbaca";
        Adjacentduplicates obj = new Adjacentduplicates(); // create object to call non-static method
        String result = obj.removeDuplicates(input);
        System.out.println("Final string after removing duplicates: " + result);
    }

    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty() || st.peek() != s.charAt(i)) {
                st.push(s.charAt(i));
            } else {
                st.pop();
            }
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}

