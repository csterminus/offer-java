package offer;

import java.util.ArrayList;
import java.util.Arrays;

public class offer38 {
    //字符串的排列
    /**
     * 我们求整个字符串的排列，可以看成两步：首先求出所有可能出现在第一个位置的字符，
     * 即把第一个字符和后面所有的字符交换。第二步固定第一个字符，求后面所有字符的排列。
     * 这个时候我们仍把后面的所有字符分成两部分：后面字符的第一个字符，以及这个字符之后的所有字符。
     * 然后把第一个字符逐一和它后面的字符交换。
     */
    private ArrayList<String> ret = new ArrayList<>();
    public ArrayList<String> Permutation(String str){
        if(str.length() == 0)
            return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars,new boolean[chars.length],new StringBuilder());
        return ret;

    }
    private void backtracking(char[] chars,boolean[] hasUsed,StringBuilder s){
        if(s.length() == chars.length){
            ret.add(s.toString());
            return;
        }
        for(int i = 0;i < chars.length;i ++ ){
            if(hasUsed[i])
                continue;
            //保证不重复
            if(i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1])
                continue;
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars,hasUsed,s);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }

}
