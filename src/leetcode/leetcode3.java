package leetcode;

public class leetcode3 {
    //最长不重复子串
    public static void main(String[] args) {
        String str = "abcab";
        leetcode3 leetcode3 = new leetcode3();
        //System.out.println(leetcode3.lengthOfLongestSubstring(str));
        System.out.println(Integer.toHexString(1542));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] temp = new int[256];
        for(int i = 0; i < temp.length;i++){
            temp[i] = -1;
        }
        int front = 0;
        int max = 0;
        for(int i = 0; i < s.length();i++){
            if(temp[s.charAt(i)] != -1 && temp[s.charAt(i)] >= front){
                //标记上一次出现的位置
                front = temp[s.charAt(i)] + 1;
            }
            temp[s.charAt(i)] = i;
            max = Math.max(max, i - front + 1);
        }
        return max;
    }
}
