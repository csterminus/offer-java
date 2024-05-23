package leetcode;

/**
 * @author chengshi
 * @date 2024/5/22 10:37
 */
public class Leetcode70 {
    public static void main(String[] args) {

    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for (int i = 2; i < n; i++) {
            res[i] = res[i - 2] + res[i - 1];
        }
        return res[n - 1];
    }
}
