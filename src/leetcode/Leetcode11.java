package leetcode;

public class Leetcode11 {
    public static void main(String[] args) {
        Leetcode11 leetcode11 = new Leetcode11();
        int[] array = new int[]{1, 1};
        System.out.println(leetcode11.maxArea(array));
    }

    /**
     * 盛水最多的容器
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if (height == null) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left <= right) {
            int sum = 0;
            if (height[left] >= height[right]) {
                sum = height[right] * (right - left);
                right--;
            } else {
                sum = height[left] * (right - left);
                left++;
            }
            if (sum > res) {
                res = sum;
            }
        }
        return res;
    }
}
