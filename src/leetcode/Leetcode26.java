package leetcode;

public class Leetcode26 {
    public static void main(String[] args) {
        Leetcode26 leetcode26 = new Leetcode26();
        System.out.println(leetcode26.strStr("a","a"));
    }
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        int start = -1;
        for(int i = 0;i < haystack.length();i++){
           if(haystack.charAt(i) == needle.charAt(0) && (i + needle.length() <= haystack.length())){
               if(haystack.substring(i,i + needle.length()).equals(needle)){
                   start = i;
                   break;
               }
           }
        }
        return start;

    }


    
}
