package leetcode;

import java.util.Arrays;

/**
 * @author chengshi
 * @date 2024/5/14 10:16
 */
public class Leetcode455 {
    public static void main(String[] args) {

    }

    public int findContentChildren(int[] g, int[] s) {
        if (s == null || s.length == 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < s.length && j < g.length) {
            if (s[i] >= g[j]) {
                count++;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return count;

    }
}
