package leetcode;

public class Leetcode151 {
    public static void main(String[] args) {
        Leetcode151 leetcode151 = new Leetcode151();
        System.out.println(leetcode151.reverseWords("the sky is blue"));
    }

    public String reverseWords(String s) {
        if(s == null || s.length() == 0){
            return null;
        }
        char[] initStr = s.toCharArray();
        char[] newStr = new char[initStr.length + 1];
        int newStrPos = 0;
        int i = initStr.length - 1;
        while(i >= 0){
            while(i >= 0 && initStr[i] == ' '){
                i--;
            }
            int right = i;
            while(i >= 0 && initStr[i] != ' '){
                i--;
            }
            for(int j = i + 1;j <= right;j++){
                newStr[newStrPos++] = initStr[j];
                if(j == right){
                    newStr[newStrPos++] = ' ';
                }
            }
        }
        if(newStrPos == 0){
            return "";
        }else {
            return new String(newStr,0,newStrPos - 1);
        }
    }

}
