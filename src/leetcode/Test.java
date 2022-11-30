package leetcode;



import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by chengshi on 2022/2/22 2:12 下午
 */
public class Test {
    public class TreeLinkNode{
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;//指向父节点

        TreeLinkNode(int val){
            this.val = val;
        }
    }
    //寻找二叉树的上一个节点
    public TreeLinkNode solution(TreeLinkNode node){
        if(node == null){
            return null;
        }
        if (node.right != null){
            TreeLinkNode pNode = node.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }else {
            while(node.next != null){
                TreeLinkNode parent = node.next;
                if(parent.left == node){
                    return parent;
                }
                node = node.next;
            }
        }
        return null;
    }


    public int solution2(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else if(nums[mid] < nums[right]){
                right = mid;
            }else{
                right --;
            }
        }
        return nums[left];
    }

    int row;
    int col;
    boolean[][] visit;
    int[][] direct;
    public boolean solution3(char[][] broad,String str){
        if(broad == null || str == null || broad.length == 0 || broad[0].length == 0){
            return false;
        }
        row = broad.length;
        col = broad[0].length;
        visit = new boolean[row][col];
        direct = new int[][]{
                {1,0},{-1,0},{0,1},{0,-1}
        };
        char[] myWord = str.toCharArray();
        for(int i = 0; i < row;i++){
            for(int j = 0; j < col;j++){
                visit[i][j] = false;
            }
        }
        for(int row1 = 0; row1 < row; row1++){
            for(int col1 = 0; col1 < col; col1++){
                boolean result = dfs(broad, row1, col1, myWord,0);
                if(result){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] broad,int i,int j,char[] myWord,int index){
        if(visit[i][j] || broad[i][j] != myWord[index]){
            return false;
        }
        if(index == myWord.length - 1){
            return true;
        }
        visit[i][j] = true;
        for(int directSize = 0; directSize < direct.length; directSize++){
            int newRow = i + direct[directSize][0];
            int newCol = j + direct[directSize][1];
            if(newRow >= 0 && newRow <= row - 1 && newCol >= 0 && newCol <= col - 1 && !visit[newRow][newCol]){
                boolean res = dfs(broad, newRow, newCol, myWord, index + 1);
                if(res){
                    return true;
                }
            }
        }

        visit[i][j] = false;
        return false;
    }

    public int moveCount(int threshold,int row,int col){
        if(threshold < 0 || row < 1 || col < 1){
            return 0;
        }
        boolean[][] visit = new boolean[row][col];
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                visit[i][j] = false;
            }
        }
        int count = dfs2(threshold,row,col,0,0,visit);
        return count;
    }

    public int dfs2(int threshold,int row,int col,int newRow,int newCol,boolean[][] visit){
        int count = 0;
        if(check(threshold,row,col,newRow,newCol,visit)){
            visit[newRow][newCol] = true;
            count = 1 +
            dfs2(threshold,row,col,newRow - 1,newCol,visit) +
            dfs2(threshold,row,col,newRow + 1,newCol,visit) +
            dfs2(threshold,row,col,newRow,newCol - 1,visit) +
            dfs2(threshold,row,col,newRow,newCol + 1,visit);
        }
        return count;
    }

    private boolean check(int threshold, int row, int col, int newRow, int newCol, boolean[][] visit) {
        return newRow >= 0 && newRow < row && newCol >= 0 && newCol < col && !visit[newRow][newCol] &&
                ((getSum(newRow) + getSum(newCol)) < threshold);
    }

    private int getSum(int sum){
        int count = 0;
        while(sum > 0){
            count = count + sum % 10;
            sum = sum / 10;
        }
        return count;
    }

    public int solution4(int res){
        int count = 0;
        while(res != 0){
            ++ count;
            res = res & (res - 1);
        }
        return count;
    }

    public long solution5(int n){
        if(n < 3){
            return n - 1;
        }
        long res = 1;
        long p = 10000000 + 7;
        long lineCount = n / 3;
        int b = n % 3;
        for (int i = 1;i < lineCount;i++){
            res = res * 3 % p;
        }
        if(b == 0){
            return res * 3;
        }
        if(b == 1){
            return res * 4;
        }
        return res;
    }


    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.equals("")){
            return new ArrayList<>();
        }
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        char[] strs = digits.toCharArray();
        char[][] mobileArray = new char[strs.length][];
        for(int i = 0;i < strs.length;i++) {
            String str = map.get(strs[i]);
            mobileArray[i] = str.toCharArray();
        }

        return null;

    }


    public static void main (String[]args){
        Test test = new Test();
        int[] nums = new int[]{5,9,10,22,35,100,-1,1,3};
        System.out.println(test.solution2(nums));

//        char[][] word = new char[][]{
//                {'a','a'}
//        };
//        String str = "aaa";
//        Test test = new Test();
//        boolean res = test.solution3(word,str);
//        Test test1 = new Test();
//        int res2 = test1.moveCount(2,2,3);
//
//        Test test2 = new Test();
//        System.out.println(test2.solution5(9));
//
//        Test test3 = new Test();
//        System.out.println(test3.iterTreeNode(test3.buildTreeNodes()));

//        Test test4 = new Test();
//        System.out.println(test4.firstIterTreeNode(test4.buildTreeNodes()));

//        Test test5 = new Test();
//        System.out.println(test5.midIterTreeNode(test5.buildTreeNodes()));

//        Test test6 = new Test();
//        System.out.println(test6.lastIterTreeNode(test6.buildTreeNodes()));
//        Test test7 = new Test();
//        System.out.println(test7.letterCombinations("234"));
    }

    public List<Integer> iterTreeNode(TreeLinkNode treeLinkNode){
        if(treeLinkNode == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeLinkNode> treeLinkNodes = new ArrayDeque<>();
        treeLinkNodes.add(treeLinkNode);
        while(!treeLinkNodes.isEmpty()){
            TreeLinkNode treeLinkNode1 = treeLinkNodes.poll();
            list.add(treeLinkNode1.val);
            if(treeLinkNode1.left != null){
                treeLinkNodes.add(treeLinkNode1.left);
            }
            if(treeLinkNode1.right != null){
                treeLinkNodes.add(treeLinkNode1.right);
            }
        }
        return list;
    }

    //根左右
    public List<Integer> firstIterTreeNode(TreeLinkNode treeLinkNode){
        if(treeLinkNode == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeLinkNode> treeLinkNodes = new Stack<>();
        treeLinkNodes.push(treeLinkNode);
        while (!treeLinkNodes.isEmpty()){
            TreeLinkNode treeLinkNode1 = treeLinkNodes.pop();
            list.add(treeLinkNode1.val);
            if(treeLinkNode1.right != null){
                treeLinkNodes.push(treeLinkNode1.right);
            }
            if(treeLinkNode1.left != null){
                treeLinkNodes.push(treeLinkNode1.left);
            }
        }
        return list;
    }

    //左根右

    public List<Integer> midIterTreeNode(TreeLinkNode treeLinkNode){
        if(treeLinkNode == null){
            return new ArrayList<>();
        }
        Stack<TreeLinkNode> treeLinkNodes = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(treeLinkNode != null || !treeLinkNodes.isEmpty()){
            while (treeLinkNode != null){
                treeLinkNodes.push(treeLinkNode);
                treeLinkNode = treeLinkNode.left;
            }
            treeLinkNode = treeLinkNodes.pop();
            list.add(treeLinkNode.val);
            treeLinkNode = treeLinkNode.right;
        }
        return list;

    }

    //左右根
    public List<Integer> lastIterTreeNode(TreeLinkNode treeLinkNode){
        if(treeLinkNode == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Stack<TreeLinkNode> treeLinkNodes = new Stack<>();
        TreeLinkNode preNode = null;
        while(treeLinkNode != null || !treeLinkNodes.isEmpty()){
            while(treeLinkNode != null){
                treeLinkNodes.push(treeLinkNode);
                treeLinkNode = treeLinkNode.left;
            }
            TreeLinkNode node = treeLinkNodes.pop();
            if(node.right != null && node.right != preNode){
                treeLinkNode = node.right;
                treeLinkNodes.push(node);
            }else {
                list.add(node.val);
                preNode = node;
            }
        }
        return list;
    }
    public TreeLinkNode buildTreeNodes(){
        TreeLinkNode treeLinkNode1 = new TreeLinkNode(1);
        TreeLinkNode treeLinkNode2 = new TreeLinkNode(2);
        TreeLinkNode treeLinkNode3 = new TreeLinkNode(3);
        TreeLinkNode treeLinkNode4 = new TreeLinkNode(4);
        TreeLinkNode treeLinkNode5 = new TreeLinkNode(5);
        TreeLinkNode treeLinkNode6 = new TreeLinkNode(6);
        TreeLinkNode treeLinkNode7 = new TreeLinkNode(7);
        treeLinkNode1.left = treeLinkNode2;
        treeLinkNode1.right = treeLinkNode3;
        treeLinkNode2.left = treeLinkNode4;
        treeLinkNode2.right = treeLinkNode5;
        treeLinkNode3.left = treeLinkNode6;
        treeLinkNode3.right = treeLinkNode7;
        return treeLinkNode1;
    }

}
