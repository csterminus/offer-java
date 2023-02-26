package leetcode;

public class Leetcode96 {
    //不同的二叉搜索树
    public static void main(String[] args) {
        Leetcode96 leetcode96 = new Leetcode96();
        System.out.println(leetcode96.numTrees(3));
    }

    public int numTrees(int n){
        int[] dp = new int[n+1];
        //dp[i] ：i个不同元素节点组成的二叉搜索树的个数
        //dp[i] += dp[以j为头结点左子树节点数量] * dp[以j为头结点右子树节点数量]
        dp[0] = 1;
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= i;j++){
                dp[i] = dp[i] + dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

}
