package leetcode;

public class Leetcode344 {
    public static void main(String[] args) {
        Leetcode344 leetcode344 = new Leetcode344();
        char[] s = new char[]{'h','e','l','l','o'};
        leetcode344.reverseString(s);
    }

    public void reverseString(char[] s) {
        if(s == null || s.length == 0){
            return;
        }
        int left = 0;
        int right = s.length - 1;
        while(left <= right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
