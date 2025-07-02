package leetcode;

public class Leetcode76 {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0, right = 0;
        int minLeft = 0, minLen = Integer.MAX_VALUE;
        int count = t.length();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (map[c] > 0) {
                count--;
            }
            map[c]--;
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                }
                char leftChar = s.charAt(left);
                map[leftChar]++;
                if (map[leftChar] > 0) {
                    count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
