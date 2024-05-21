package leetcode;

/**
 * @author chengshi
 * @date 2024/5/21 16:46
 */
public class Leetcode74 {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix.length - 1;
        int high = matrix[0].length - 1;
        int rCol = 0;
        int rHigh = high;
        while (rCol < col && rHigh > 0) {
            if (matrix[rCol][rHigh] == target) {
                return true;
            } else if (matrix[rCol][rHigh] < target) {
                rCol++;
            } else {
                rHigh--;
            }
        }
        return false;
    }
}
