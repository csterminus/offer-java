public class offer46 {
    //把数字翻译成字符串
    /**
     * 题目描述：给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。
     * 一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。实现一个函数
     * ，用来计算一个数字有多少种不同的翻译方法。
     * 用递归自顶向下分析，用动态规划自低向上求解
     * •定义问题：当最开始的一个或者两个数字被翻译成一个字符后，我们接着翻译后面剩下的数字；
     * •用一个递归式来表示：定义f(i)表示从第i位数字开始的不同翻译的数目，那么f(i) = f(i+1) + g(i,i+1)*f(i+2)；
     * 当第i位和第i+1位两位数字拼接起来的数字在10~25的范围内时，函数g(i,i+1)的值为1，否则为0。
     * •该问题使用上面的递归方法会存在很多重复子问题。所以我们使用动态规划的方法，自低向上求解问题，消除重复子问题。
     */
   public int numDecodings(String s){
       if(s == null || s.length() == 0)
           return 0;
       int n = s.length();
       int[] dp = new int[n + 1];
       dp[0] = 1;
       dp[1] = s.charAt(0) == '0' ? 0 : 1;
       for(int i = 2; i < n; i++){
           int one = Integer.valueOf(s.substring(i - 1,i));
           if(one != 0)
               dp[i] = dp[i] + dp[i -1];
           if(s.charAt(i - 2) == '0')
               continue;
           int two = Integer.valueOf(s.substring(i - 2,i));
           if(two <= 26)
               dp[i] = dp[i] + dp[i - 2];
       }
       return dp[n];
   }
}
