package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode17 {
    List<String> list = new ArrayList<>();

    //电话号码的字母组合
    public static void main(String[] args) {
        Leetcode17 leetcode17 = new Leetcode17();
        System.out.println(leetcode17.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return list;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(digits, map, 0, "");
        return list;
    }

    public void dfs(String digits, Map<Character, String> map, int u, String path) {
        int n = digits.length();
        if (u == n) {
            list.add(path);
            return;
        }
        String s = map.get(digits.charAt(u));
        for (int i = 0; i < s.length(); i++) {
            String cur = path;
            path = path + s.charAt(i);
            dfs(digits, map, u + 1, path);
            path = cur;
        }
    }


}
