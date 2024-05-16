package leetcode;

import java.util.Stack;

/**
 * @author chengshi
 * @date 2024/5/15 9:00
 */
public class Leetcode376 {
    //1,7,4,9,2,5
    //1,17,5,10,13,15,10,5,16,8
    //1,2,3,4,5,6,7,8,9
    public static void main(String[] args) {
        Leetcode376 leetcode376 = new Leetcode376();
        leetcode376.wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2 && nums[0] != nums[1]) {
            return 2;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (index % 2 == 1) {
                if (nums[i] > stack.peek()) {
                    stack.push(nums[i]);
                    index++;
                }
            } else {
                if (nums[i] < stack.peek()) {
                    stack.push(nums[i]);
                    index++;
                }
            }
        }
        return stack.size();
    }
}
