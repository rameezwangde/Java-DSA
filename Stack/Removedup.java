package Stack;

import java.util.Stack;

public class Removedup {
    public static void main(String[] args) {
        String input = "cbacdcbc";
        System.out.println("Result: " + removeDuplicateLetters(input));
    }

    // Method to remove duplicate letters and return the smallest lexicographical order string
    public static String removeDuplicateLetters(String s) {
        // Frequency array to count occurrences of each character (a to z)
        int[] freq = new int[26];

        // Visited array to track characters already in the result
        boolean[] visited = new boolean[26];

        // Count frequency of each character in the string
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Stack to maintain result characters in order
        Stack<Character> st = new Stack<>();

        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a'; // Get index for the character

            // Decrease frequency as this character is now being considered
            freq[idx]--;

            // If the character is already in the stack/result, skip it
            if (visited[idx]) continue;

            // Remove characters from stack if:
            // 1. They are greater than the current character (to maintain order)
            // 2. They appear later again in the string (their freq > 0)
            while (!st.isEmpty() && ch < st.peek() && freq[st.peek() - 'a'] > 0) {
                visited[st.pop() - 'a'] = false; // Mark the removed char as not visited
            }

            // Add current character to stack and mark it as visited
            st.push(ch);
            visited[idx] = true;
        }

        // Build the result from stack
        StringBuilder res = new StringBuilder();
        for (char ch : st) {
            res.append(ch);
        }

        // Return result as a string
        return res.toString();
    }
}

