package offer;

public class offer29 {
    //顺时针打印矩阵
    public class PrintMatrix{
        public void printMatrixClockwisely(int[][] numbers,int rows,int columns){
            if(numbers == null || rows == 0 || columns == 0){
                return;
            }
            int start = 0;
            while(start * 2 < columns && start * 2 <rows){
                printMatrixInCircle(numbers,rows,columns,start);
                start++;
            }
        }
        public void printMatrixInCircle(int[][] numbers,int rows,int columns,int start){
            //终止列号
            int endx = columns - 1 - start;
            //终止行号
            int endy = rows - 1 - start;
            //从左至右打印一行
            for(int i = start; i <= endx; i++){
                System.out.println(numbers[start][i] + " ");
            }
            //从上到下打印一列
            //条件：终止行号大于起始行号
            if(endy > start){
                for(int i = start + 1; i <= endy; i++){
                    System.out.println(numbers[i][endx] + " ");
                }
            }
            //从右至左打印一行
            //条件：终止行号大于起始行号，终止列号大于起始列号
            if(endy > start && endx > start){
                for(int i = endx - 1; i >= start; i++){
                    System.out.println(numbers[endy][i] + " ");
                }
            }
            //从上到下打印一列
            //条件：终止行号比起始行号至少大2，终止列号大于起始列号
            if(endy - 1 > start && endx > start){
                for(int i = endy - 1; i >= start + 1; i--){
                    System.out.println(numbers[i][start] + " ");
                }
            }
        }
    }

}
