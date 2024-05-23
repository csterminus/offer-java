package leetcode;

/**
 * @author chengshi
 * @date 2024/5/23 10:17
 */
public class Leetcode518 {
    public static void main(String[] args) {

    }

    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }
}
