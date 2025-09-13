package Strings;

public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        String reversed = reverse(s);
        System.out.println("Reversed: " + reversed);
    }

    public static String reverse(char[] s) {
        int sp = 0;
        int ep = s.length - 1;
        while (sp <= ep) {
            char temp = s[sp];
            s[sp] = s[ep];
            s[ep] = temp;
            sp++;
            ep--;
        }
        return new String(s);
    }
}

