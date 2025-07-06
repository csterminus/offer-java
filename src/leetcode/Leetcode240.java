package leetcode;

public class Leetcode240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[row].length - 1;
        while(row < matrix.length && col >= 0){
            int temp = matrix[row][col];
            if(temp == target){
                return true;
            }else if(temp > target){
                col--;
            }else{
                row++;
            }

        }
        return false;
    }
}
