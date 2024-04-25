package leetcode;

import java.util.Stack;

/**
 * @author chengshi
 * @date 2024/4/23 16:22
 */
public class Leetcode155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());  // return 0
        System.out.println(minStack.getMin()); // return -2
    }

    public static class MinStack {
        private Stack<Integer> stack;
        private Integer min;

        public MinStack() {
            this.stack = new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                min = val;
            } else {
                if (val < min) {
                    min = val;
                }
            }
            stack.push(val);
        }

        public void pop() {
            if (stack.pop().equals(min)) {
                if (!stack.isEmpty()) {
                    min = stack.peek();
                    for (int i = 0; i < stack.size(); i++) {
                        if (stack.get(i) < min) {
                            min = stack.get(i);
                        }
                    }
                }
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
