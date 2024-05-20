package leetcode;

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
        leetcode376.wiggleMaxLength(new int[]{33, 53, 12, 64, 50, 41, 45, 21, 97, 35, 47, 92, 39, 0, 93, 55, 40, 46, 69, 42, 6, 95, 51, 68, 72, 9, 32, 84, 34, 64, 6, 2, 26, 98, 3, 43, 30, 60, 3, 68, 82, 9, 97, 19, 27, 98, 99, 4, 30, 96, 37, 9, 78, 43, 64, 4, 65, 30, 84, 90, 87, 64, 18, 50, 60, 1, 40, 32, 48, 50, 76, 100, 57, 29, 63, 53, 46, 57, 93, 98, 42, 80, 82, 9, 41, 55, 69, 84, 82, 79, 30, 79, 18, 97, 67, 23, 52, 38, 74, 15});
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2 && nums[0] != nums[1]) {
            return 2;
        }
        int beginState = 0;
        int upState = 1;
        int downState = 2;
        int length = 1;
        int state = beginState;
        for (int i = 1; i < nums.length; i++) {
            if (state == beginState) {
                if (nums[i] < nums[i - 1]) {
                    length++;
                    state = downState;
                } else if (nums[i] > nums[i - 1]) {
                    length++;
                    state = upState;
                }
            }
            if (state == downState) {
                if (nums[i] > nums[i - 1]) {
                    length++;
                    state = upState;
                }
            }
            if (state == upState) {
                if (nums[i] < nums[i - 1]) {
                    length++;
                    state = downState;
                }
            }
        }
        return length;
    }
}
