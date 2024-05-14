package leetcode;


import java.util.Stack;

/**
 * @author chengshi
 * @date 2024/5/14 11:24
 */
public class Leetcode402 {
    public static void main(String[] args) {
        Leetcode402 leetcode402 = new Leetcode402();
        leetcode402.removeKdigits("1432219", 3);
    }

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            while (!stack.isEmpty() && stack.peek() > digit && k > 0) {
                stack.pop();
                k--;
            }
            if (digit == '0' && stack.isEmpty()) {
                continue;
            }
            stack.push(digit);
        }
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        if (stack.isEmpty()) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.peek());
            stack.pop();
        }

        return stringBuilder.reverse().toString();
    }
}
