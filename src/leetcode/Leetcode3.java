package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode3 {
    //最长不重复子串
    public static void main(String[] args) {
        String str = "abcab";
        Leetcode3 leetcode3 = new Leetcode3();
        System.out.println(leetcode3.lengthOfLongestSubstring(str));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        for(int i = 0;i < s.length();i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            max = Math.max(max,i - left + 1);
        }
        return max;
    }
}
