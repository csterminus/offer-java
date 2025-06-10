package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        if(p == null || p.length() == 0){
            return new ArrayList<>();
        }
        if(s.length() < p.length()){
            return new ArrayList<>();
        }
        char[] tempChars = p.toCharArray();
        Arrays.sort(tempChars);
        String tempStr = new String(tempChars);
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i <= s.length() - p.length();i++){
            char[] chars = s.substring(i,i + p.length()).toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            if(sortStr.equals(tempStr)){
                list.add(i);
            }
        }
        return list;
    }
}
