package leetcode;

import java.util.Stack;

/**
 * @author chengshi
 * @date 2024/4/23 16:22
 */
public class Leetcode155 {
    public static void main(String[] args) {

    }

    public class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minStack;

        public MinStack() {
            this.stack = new Stack<>();
            this.minStack = new Stack<>();
        }

        public void push(int val) {
            if (stack.isEmpty()) {
                stack.push(val);
                minStack.push(val);
            } else {
                if (val < minStack.peek()) {
                    minStack.push(val);
                }
            }
            stack.push(val);
        }

        public void pop() {
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
