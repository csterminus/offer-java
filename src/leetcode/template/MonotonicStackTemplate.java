package leetcode.template;

import java.util.Stack;

/**
 * @author chengshi
 * @date 2024/6/17 16:50
 */
public class MonotonicStackTemplate {
    //单调递增
    //单调递增栈是指栈内的元素从栈底到栈顶按递增顺序排列。即，每当有新元素入栈时，会不断将栈顶大于新元素的元素出栈，直到栈为空或栈顶元素小于等于新元素
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        // 对于没有下一个更大元素的元素，设置为 -1（或根据实际需求设置）
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        return result;
    }

    //单调递减
    // 单调递减栈是指栈内的元素从栈底到栈顶按递减顺序排列。即，每当有新元素入栈时，会不断将栈顶小于新元素的元素出栈，直到栈为空或栈顶元素大于等于新元素
    public int[] nextSmallerElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                result[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        // 对于没有下一个更小元素的元素，设置为 -1（或根据实际需求设置）
        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        return result;
    }

}
