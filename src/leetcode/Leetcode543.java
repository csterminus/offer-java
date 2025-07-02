package leetcode;

//获取二叉树的直径
public class Leetcode543 {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = new int[1];
        getDepth(root, maxDiameter);
        return maxDiameter[0];
    }

    private int getDepth(TreeNode node, int[] maxDiameter) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left, maxDiameter);
        int right = getDepth(node.right, maxDiameter);
        maxDiameter[0] = Math.max(maxDiameter[0], left + right);
        return Math.max(left, right) + 1;
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
