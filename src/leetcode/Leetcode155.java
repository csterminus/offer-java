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
        // 一个栈叫做 stack，负责栈的正常操作
        Stack<Integer> stack;
        // 一个栈叫做 minStack，负责获取 stack 中的最小值，它等价于遍历 stack 中的所有元素，把升序的数字都删除掉，留下一个从栈底到栈顶降序的栈
        Stack<Integer> minStack;

        public MinStack() {
            // 初始化 stack
            stack = new Stack<>();

            // 初始化 minStack
            minStack = new Stack<>();
        }

        public void push(int x) {
            // 新添加的元素添加到 stack 中
            stack.push(x);

            // 判断 minStack 是否为空，如果为空，直接同时把新添加的元素添加到 minStack 中

            // 如果 minStack 不为空
            if (!minStack.isEmpty()) {
                // 获取 minStack 的栈顶元素
                int top = minStack.peek();
                // 只有新添加的元素不大于 top 才允许添加到 minStack 中，目的是为了让 minStack 从栈底到栈顶是降序的
                if (x <= top) {
                    // 此时，新添加的元素 x 小于 top，加入到 minStack 后依旧是从栈底到栈顶是降序的
                    minStack.push(x);
                }
            } else {
                // 此时，minStack 中没有元素，所以直接把新添加的元素添加到 minStack 中
                minStack.push(x);
            }
        }

        public void pop() {
            // 让 stack 执行正常的 pop 操作就行
            int pop = stack.pop();

            // 由于 minStack 中的所有元素都是来自于 stack 中，所以 stack 删除元素后，minStack 也要考虑是否需要删除元素
            // 否则的话，minStack 有可能保存一个 stack 中不存在的元素

            // 首先，获取 minStack 的栈顶元素
            int top = minStack.peek();
            // 再判断 top 这个栈顶元素是否和 stack 移除的元素相等，如果相等，那么需要把 minStack 中的栈顶元素一并移除
            if (pop == top) {
                // 移除 minStack 的栈顶元素
                minStack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}
