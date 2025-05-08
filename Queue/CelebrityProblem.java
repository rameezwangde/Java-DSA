package Queue;

import java.util.Stack;

public class CelebrityProblem {
    public static void main(String[] args) {
        int[][] M = {
            {0, 1, 0},
            {0, 0, 0},
            {0, 1, 0}
        };
        int n = M.length;
        int result = celeb(M, n);
        System.out.println("Celebrity is: " + result);
    }

    public static int celeb(int[][] M, int n) {
        Stack<Integer> st = new Stack<>();

        // Step 1: Push all persons to the stack
        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        // Step 2: Eliminate non-celebrities
        while (st.size() >= 2) {
            int a = st.pop();
            int b = st.pop();

            if (M[a][b] == 1) {
                // a knows b => a can't be celebrity
                st.push(b);
            } else {
                // a doesn't know b => b can't be celebrity
                st.push(a);
            }
        }

        // Step 3: Verify candidate
        int cand = st.pop();

        for (int i = 0; i < n; i++) {
            if (i != cand) {
                if (M[cand][i] == 1 || M[i][cand] == 0) {
                    return -1;
                }
            }
        }

        return cand;
    }
}

