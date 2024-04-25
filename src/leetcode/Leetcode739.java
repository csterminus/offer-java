package leetcode;


import java.util.Stack;

/**
 * @author chengshi
 * @date 2024/4/25 10:30
 */
public class Leetcode739 {
    public static void main(String[] args) {
        Leetcode739 leetcode739 = new Leetcode739();
        leetcode739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
    }

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) {
            return null;
        }
        if (temperatures.length == 1) {
            return new int[]{0};
        }
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                res[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
