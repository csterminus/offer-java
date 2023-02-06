package leetcode;

import java.util.Stack;

public class leetcode20 {
    public static void main(String[] args) {
        String str = "]]";
        leetcode20 leetcode20 = new leetcode20();
        System.out.println(leetcode20.isValid(str));
    }

    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'){
                if(stack.isEmpty()){
                    return false;
                }
                if(s.charAt(i) == ')' && stack.pop() != '('){
                    return false;
                }
                if(s.charAt(i) == '}' && stack.pop() != '{'){
                    return false;
                }
                if(s.charAt(i) == ']' && stack.pop() != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
