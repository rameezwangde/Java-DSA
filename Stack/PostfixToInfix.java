package Stack;

import java.util.Stack;

public class PostfixToInfix {
    public static void main(String[] args) {
        String postfix = "ab-de+f*/";
        String infix = postfixToInfix(postfix);
        System.out.println("Infix: " + infix); // Expected: ((a + b) * c)
    }
    public static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch=='^';

    }
    public static String postfixToInfix(String s){
        Stack<String> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                st.push(ch+"");
            }else if(isOperator(ch)){
                String b=st.pop();
                String a=st.pop();
                String exp="("+a+" "+ch+" "+b+")";
                st.push(exp);
            }
        }
        return st.peek();
    }
}
