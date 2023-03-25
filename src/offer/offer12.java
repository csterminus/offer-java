package offer;

public class offer12 {
    /**
     * 题目描述：判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一个格子开始，
     * 每一步可以在矩阵中向上下左右移动一个格子。如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
     * 解题思路：使用回溯法（backtracking）进行求解，它是一种暴力搜索方法，通过搜索所有可能的结果来求解问题。
     * 回溯法在一次搜索结束时需要进行回溯（回退），将这一次搜索过程中设置的状态进行清除，从而开始一次新的搜索过程。
     * 例如下图示例中，从 f 开始，下一步有 4 种搜索可能，如果先搜索 b，
     * 需要将 b 标记为已经使用，防止重复使用。在这一次搜索结束之后，需要将 b 的已经使用状态清除，并搜索 c。
     */
    private final static int[][] next = {{0,-1},{0,1},{-1,0},{1,0}};
    private int rows;
    private int cols;

    public boolean hasPath(char[] array,int rows,int cols,char[] str){
        if(rows == 0 || cols == 0) return false;
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] matrix = buildMatrix(array);
        for(int i= 0;i < rows; i++){
            for(int j = 0;j < cols; j++){
                if(backtracking(matrix,str,marked,0,i,j))
                    return true;
            }
        }
        return false;
    }

    private boolean backtracking(char[][] matrix,char[] str,boolean[][] marked,int pathLen,int r,int c){
        if(pathLen == str.length) return true;
        if(r < 0 || r >=rows ||c < 0 || c >= cols
                || matrix[r][c] != str[pathLen] || marked[r][c]){
            return false;
        }

        marked[r][c] = true;
        for(int[] n : next){
            if(backtracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1]))
                return true;
        }
        marked[r][c] = false;
        return false;
    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        for (int r = 0, idx = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                matrix[r][c] = array[idx++];
            return matrix;
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        char[] chars = word.toCharArray();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 从 (0, 0) 点开始进行 dfs 操作，不断地去找，
                // 如果以 (0, 0) 点没有对应的路径的话，那么就从 (0, 1) 点开始去找
                if (dfs(board, chars, visited, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] chars, boolean[][] visited, int i, int j, int start) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || chars[start] != board[i][j] || visited[i][j]) {
            return false;
        }
        if (start == chars.length - 1) {
            return true;
        }
        visited[i][j] = true;
        boolean ans = false;
        ans = dfs(board, chars, visited, i + 1, j, start + 1)
                || dfs(board, chars, visited, i - 1, j, start + 1)
                || dfs(board, chars, visited, i, j + 1, start + 1)
                || dfs(board, chars, visited, i, j - 1, start + 1);
        visited[i][j] = false;
        return ans;
    }
}

