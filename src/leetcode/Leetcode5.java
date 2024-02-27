package leetcode;

//最长回文字串
public class Leetcode5 {
    public static void main(String[] args) {
        String s = "bb";
        Leetcode5 leetcode5 = new Leetcode5();
        System.out.println(leetcode5.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() == 1) {
            return s;
        }
        int maxLen = 1;
        String maxStr = "";
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j <= i + 1 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (j - i + 1 >= maxLen) {
                        maxLen = j - i + 1;
                        maxStr = s.substring(i, j + 1);
                    }
                }
            }
        }
        return maxStr;
    }
}
