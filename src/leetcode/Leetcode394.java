package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Leetcode394 {
    public static void main(String[] args) {
        Leetcode394 leetcode394 = new Leetcode394();
        System.out.println(leetcode394.decodeString("2[abc]3[cd]ef"));
    }

    public String decodeString(String s) {
        if(s == null || s.length() == 0){
            return null;
        }
        Deque<Integer> stack_digit = new ArrayDeque<>();
        Deque<StringBuilder> stack_string = new ArrayDeque<>();
        int tNum = 0;
        StringBuilder tString = new StringBuilder();
        int i = 0;
        //遍历字符串 分4中情况
        while(i<s.length()){
            char ch = s.charAt(i++);
            if(ch == '['){ //如果是"[" 将临时数字和临时字符串入栈
                stack_digit.push(tNum);
                stack_string.push(tString);
                tNum = 0;
                tString = new StringBuilder();
            }else if(ch == ']'){ //如果是"]" 将数字和字符串出栈 此时临时字符串res = 出栈字符串 + 出栈数字*res
                StringBuilder temp = stack_string.pop();
                int count = stack_digit.pop();
                for(int j = 0;j < count;j++){
                    temp.append(tString.toString());
                }
                tString = temp;
            }else if('0' <= ch && ch <= '9'){
                //如果是数字 将字符转成整型数字 ch-‘0’。 注意数字不一定是个位 比如100[a] 所以digit要*10
                tNum = tNum * 10 + ch - '0';
            }else{
                //如果是字符 直接将字符放在临时字符串中
                tString.append(ch);
            }
        }
        return tString.toString();
    }
}
