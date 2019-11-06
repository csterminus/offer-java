public class offer28 {
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }
    }
    //判断二叉树是否对称
    public class SymmetricalBinayTree{
        public boolean isSymmetrical(TreeNode root){
            return isSymmetrical(root,root);
        }

        public boolean isSymmetrical(TreeNode root1,TreeNode root2){
            //如果两个根节点都是null
            if(root1 == null && root2 == null){
                return true;
            }

            //如果只有一个根节点是null
            if(root1 == null || root2 == null){
                return false;
            }

            if(root1.val != root2.val){
                return false;
            }
            return isSymmetrical(root1.left,root2.right) && isSymmetrical(root1.right,root2.left);
        }
    }
}
