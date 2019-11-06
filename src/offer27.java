public class offer27 {
    //二叉树的镜像
    public class TreeNode{
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val){
            this.val = val;
        }
    }
    //递归实现
    public class MirrorTree{
        public void mirrorRecursively(TreeNode root){
            if(root == null){
                return;
            }
            if(root.left == null && root.right == null){
                return;
            }

            //交换根节点的左右子树
            TreeNode tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;

            if(root.left != null){
                mirrorRecursively(root.left);
            }
            if(root.right != null){
                mirrorRecursively(root.right);
            }
        }
    }
}
