package leetcode;

import java.util.Stack;

/**
 * @author chengshi
 * @date 2024/4/25 17:13
 */
public class Leetcode232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }

    public static class MyQueue {
        private Stack<Integer> stack = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            stack.push(x);
        }

        public int pop() {
            if (stack2.isEmpty()) {
                while (!stack.isEmpty()) {
                    stack2.push(stack.pop());
                }
                return stack2.pop();
            } else {
                return stack2.pop();
            }
        }

        public int peek() {
            if (stack2.isEmpty()) {
                while (!stack.isEmpty()) {
                    stack2.add(stack.pop());
                }
                return stack2.peek();
            } else {
                return stack2.peek();
            }
        }

        public boolean empty() {
            return stack.isEmpty() && stack2.empty();
        }
    }
}
