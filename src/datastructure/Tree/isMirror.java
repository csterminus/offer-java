package datastructure.Tree;

public class isMirror {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    //判断是否为镜像二叉树
    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        return isEqual(root.left,root.right);
    }
    public boolean isEqual(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        if(root1.val != root2.val)
            return false;
        return isEqual(root1.left,root2.right) && isEqual(root1.right,root2.left);//关键代码，镜像特点
    }

}
