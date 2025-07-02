package leetcode;

//计算二叉树的最大路径和
public class Leetcode124 {
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        getPathSum(root,maxSum);
        return maxSum[0];
    }

    //首先，函数检查传入的节点treeNode是否为null。如果是，说明已经到达了叶节点的子节点，返回0，表示该路径的和为0。
    //然后，递归地计算左子树和右子树中以当前节点为根的子树中的最大单边路径和（即从当前节点到叶节点的最大和），并将负数结果替换为0，因为负数路径和对求最大和没有贡献。
    //接着，更新全局最大路径和maxSum[0]。比较当前全局最大路径和与当前节点值加上左右子树最大单边路径和的和，取较大者作为新的全局最大路径和。
    //最后，返回以当前节点为根的子树中的最大单边路径和，即当前节点值与左右子树中较大单边路径和的和。
    public int getPathSum(TreeNode treeNode,int[] maxSum){
        if(treeNode == null){
            return 0;
        }
        int left = Math.max(0,getPathSum(treeNode.left,maxSum));
        int right = Math.max(0,getPathSum(treeNode.right,maxSum));
        maxSum[0] = Math.max(maxSum[0],left + right + treeNode.val);
        return Math.max(left, right) + treeNode.val;
    }


    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode(int val){
            this.val = val;
        }
    }
}
