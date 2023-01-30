package leetcode;

import java.util.Arrays;

public class leetcode14 {
    public static void main(String[] args) {
        String[] strings = new String[]{"a","ab"};
        leetcode14 leetcode14 = new leetcode14();
        System.out.println(leetcode14.longestCommonPrefix(strings));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null ||strs.length == 0){
            return "";
        }
        Arrays.sort(strs,(a,b) -> Integer.compare(a.length(),b.length()));
        boolean temp = true;
        String res = "";
        for(int i = 0; i < strs[0].length();i++){
            for(int j = 0;j < strs.length;j++){
                if(!strs[0].substring(0, i + 1).equals(strs[j].substring(0, i + 1))){
                    temp = false;
                    break;
                }
            }
            if(temp) {
                res = strs[0].substring(0, i + 1);
            }
        }
        return res;
    }
}
