package leetcode.template;

/**
 * @author chengshi
 * @date 2024/6/17 11:12
 */
public class PackageTemplate {
    public static int One_Zero_template(int[] weights, int[] values, int capacity) {
        int len = weights.length;
        //代表的是第i个物品，在容量为j的情况下能获取到的最大价值
        int[][] dp = new int[len][capacity + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= capacity; j++) {
            //当存储第一个物品时，背包容量为j,能存储的最大价值
            dp[0][j] = j >= weights[0] ? values[0] : 0;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= capacity; j++) {
                //不拿第i个物品时的最大价值 w[i] > j，即第 i 个物品的重量大于背包容量 j，则不放入该物品。此时最优解的值等同于将前 i-1 个物品放入容量为 j 的背包中最优解的值，即 F[i][j] = F[i-1][j]。
                int notTake = dp[i - 1][j];
                int take = 0;
                //w[i] ≤ j，即第 i 个物品的重量不大于背包容量 j，则有以下两种情况的最大值决定：
                //
                //不放入该物品，此时最优解的值等同于将前 i-1 个物品放入容量为 j 的背包中最优解的值，即 F[i][j] = F[i-1][j]。
                //放入该物品，此时背包的剩余容量为 j-w[i]，则最优解的值等同于“第 i 个物品的价值”与“前 i-1 个物品放入容量为 j-w[i] 的背包中最优解的值”之和，即F[i][j] = v[i] + F[i - 1][j - w[i]]。
                if (j >= weights[i]) {
                    take = dp[i - 1][j - weights[i]] + values[i];
                }
                dp[i][j] = Math.max(notTake, take);
            }
        }
        return dp[len - 1][capacity];
    }

    public static int CompleteKnapsack3(int[] w, int[] v, int n, int m) {
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (w[i - 1] <= j)
                    dp[j] = Math.max(dp[j], dp[j - w[i - 1]] + v[i - 1]);
            }
        }
        return dp[m];
    }

    //完全背包
    //对于完全背包问题，由于每种物品有任意多个，那么我们可以再加入一层循环 k，k 代表第 i 种物品有 k 件。
    //
    //则 v[i] 应修改为 k*v[i]，w[i] 应修改为 k*w[i]，且应对遍历的k*v[i]+dp[i-1][j-k*w[i]]取最大值
    public int completeKnapsack(int[] weights, int[] values, int W) {
        int N = weights.length;
        int[] dp = new int[W + 1];

        for (int i = 0; i < N; i++) {
            for (int w = weights[i]; w <= W; w++) {
                dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
            }
        }
        return dp[W];
    }

    //多重背包
    public int multipleKnapsack(int[] weights, int[] values, int[] counts, int W) {
        int N = weights.length;
        int[] dp = new int[W + 1];

        for (int i = 0; i < N; i++) {
            if (counts[i] * weights[i] >= W) {
                // 如果物品的数量足够多，相当于完全背包问题
                for (int w = weights[i]; w <= W; w++) {
                    dp[w] = Math.max(dp[w], dp[w - weights[i]] + values[i]);
                }
            } else {
                // 多重背包问题
                int count = counts[i];
                for (int k = 1; count > 0; k <<= 1) {
                    int num = Math.min(k, count);
                    count -= num;
                    int weight = num * weights[i];
                    int value = num * values[i];
                    for (int w = W; w >= weight; w--) {
                        dp[w] = Math.max(dp[w], dp[w - weight] + value);
                    }
                }
            }
        }
        return dp[W];
    }

}
