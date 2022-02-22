package offer;

public class offer33 {
    //二叉搜索树的后序遍历序列
    //后序序列最后一个值是root 左子树都比根节点小 右子树都比根节点大
    public static boolean verifySquenceOfBST(int[] arr, int start, int end) {

        if (start >= end) {
            return true;
        }

        //根节点
        int rootValue = arr[end];

        // 在二叉搜索树中左子树节点的值小于根节点的值
        int index = start;
        for (; index <= end-1; index++) {
            if (arr[index] > rootValue)
                break;
        }

        int end2 = index - 1;
        int start2 = index;

        // 在二叉搜索树中右子树节点的值大于根节点的值
        index = start2;
        while (index <= end-1) {
            if (arr[index] < rootValue) {
                return false;
            }
            index++;
        }

        /**
         * 判断左右子树是不是二叉搜索树
         */
        if (verifySquenceOfBST(arr, start, end2) && verifySquenceOfBST(arr, start2, end - 1))
            return true;
        else
            return false;
    }

}
