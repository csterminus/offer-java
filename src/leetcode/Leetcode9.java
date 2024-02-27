package leetcode;

public class Leetcode9 {
    //判断数字是否回文
    public static void main(String[] args) {
        Leetcode9 leetcode9 = new Leetcode9();
        System.out.println(leetcode9.isPalindrome(111));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        String str = "";
        int temp = x;
        int remainder;
        while (temp > 0) {
            remainder = temp % 10;
            str = str + remainder;
            temp = temp / 10;
        }
        int left = 0;
        int right = str.length() - 1;
        boolean res = true;
        while (left <= right && res) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return res;
    }
}
