package leetcode;

import java.util.HashMap;
import java.util.Map;

public class leetcode13 {
    //罗马数字转整数
    public static void main(String[] args) {
        leetcode13 leetcode13 = new leetcode13();
        System.out.println(leetcode13.romanToInt("MCMXCIV"));
    }
    public int romanToInt(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int res = map.get(s.charAt(s.length() - 1));
        for(int i = s.length() - 2;i >= 0;i--){
            if(s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')){
                res = res - map.get(s.charAt(i));
            }else if(s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')){
                res = res - map.get(s.charAt(i));
            }else if(s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')){
                res = res - map.get(s.charAt(i));
            }else {
                res = res + map.get(s.charAt(i));
            }
        }
        return res;
    }



}
