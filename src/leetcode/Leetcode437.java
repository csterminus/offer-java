package leetcode;

//符合给定和的二叉树路径数
public class Leetcode437 {
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return 0;
        }
        return pathSum2(root,targetSum) + pathSum2(root.right, targetSum) + pathSum2(root.left, targetSum);
    }

    public int pathSum2(TreeNode node,int target){
        if(node == null){
            return 0;
        }
        return (node.val == target ? 1 : 0) + pathSum2(node.left,target - node.val)
        + pathSum2(node.right,target - node.val);
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
