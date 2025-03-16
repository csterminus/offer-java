package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author chengshi
 * @date 2024/8/20 17:32
 */
public class Leetcode234 {
    public static void main(String[] args) {

    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            queue.add(head.val);
            stack.add(head.val);
            head = head.next;
        }
        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }
        return true;
    }

    static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
