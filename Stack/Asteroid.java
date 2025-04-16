package Stack;

import java.util.Stack; // ✅ Required import

public class Asteroid {
    public static void main(String[] args) {
        int[] input = {5, 10, -5};
        int[] result = asteroidCollision(input);

        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public static int[] asteroidCollision(int[] a) {
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                st.push(a[i]);
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(a[i])) {
                    st.pop();
                }

                if (!st.isEmpty() && st.peek() == Math.abs(a[i])) {
                    st.pop();
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(a[i]);
                }
                // If st.peek() > Math.abs(a[i]), current asteroid explodes (do nothing)
            }
        }

        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;
    }
}

