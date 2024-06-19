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

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // Odd length palindrome
            int len2 = expandAroundCenter(s, i, i + 1); // Even length palindrome
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
