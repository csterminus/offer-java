package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {
    //括号生成，生成所有有效的括号组合
    public static void main(String[] args) {
        Leetcode22 leetcode22 = new Leetcode22();
        System.out.println(leetcode22.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String str = "";
        generateParenthesis(res, str, n, n);
        return res;
    }

    private void generateParenthesis(List<String> res, String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        if (left > 0) {
            generateParenthesis(res, str + '(', left - 1, right);
        }
        if (right > left) {
            generateParenthesis(res, str + ')', left, right - 1);
        }
    }
}
