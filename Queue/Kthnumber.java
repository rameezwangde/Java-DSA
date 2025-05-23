import java.util.*; // ✅ Import collections

public class Kthnumber {
    public static void main(String[] args) {
        int k = 5;
        System.out.println("The " + k + "th number is: " + kthnumber(k));
    }

    public static String kthnumber(int k) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        q.add("2");

        String ans = "";

        for (int i = 0; i < k; i++) {
            ans = q.remove();         // Remove front
            q.add(ans + "1");         // Add children
            q.add(ans + "2");
        }

        return ans;
    }
}



