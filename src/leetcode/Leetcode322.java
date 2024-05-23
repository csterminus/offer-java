package leetcode;

/**
 * @author chengshi
 * @date 2024/5/22 15:11
 */
public class Leetcode322 {
    public static void main(String[] args) {
        Leetcode322 leetcode322 = new Leetcode322();
        leetcode322.coinChange(new int[]{1, 2, 5}, 5);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[coins[i]] = -1;
        }
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != -1) {
                    if (dp[i] == -1 || dp[i - coins[j]] + 1 < dp[i]) {
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
            System.out.println(dp[i]);
        }

        return dp[amount];
    }
}
