package leetcode;

/**
 * @author chengshi
 * @date 2024/5/14 11:41
 */
public class Leetcode55 {
    public static void main(String[] args) {
        Leetcode55 leetcode55 = new Leetcode55();
        leetcode55.canJump(new int[]{3, 2, 1, 0, 4});
    }

    public boolean canJump(int[] nums) {
        int[] jump = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            jump[i] = i + nums[i];
        }
        int index = 0;
        int maxJump = jump[0];
        while (index < nums.length && index <= maxJump) {
            if (maxJump < jump[index]) {
                maxJump = jump[index];
            }
            index++;
        }
        if (index > nums.length - 1) {
            return true;
        }
        return false;
    }
}
