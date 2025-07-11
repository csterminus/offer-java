package leetcode;

import java.util.ArrayList;
import java.util.List;

//螺旋矩阵
public class Leetcode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int top = 0,bottom = matrix.length - 1;
        int left = 0,right = matrix[0].length - 1;
        while(left <= right && top <= bottom){
            for(int i = left;i <= right;i++){
                result.add(matrix[top][i]);
            }
            top++;
            for(int i = top;i <= bottom;i++){
                result.add(matrix[i][right]);
            }
            right--;
            if (top > bottom || left > right) break;

            for(int i = right;i >= left;i--){
                result.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i = bottom;i >= top;i--){
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
}
