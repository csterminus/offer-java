package offer;

import java.util.HashMap;

public class offer26 {
    //树的子结构
    /**
     * 解题思路：首先判断根节点值是不是相同，在判断结构是否相同，最后判断结点的值是否相同
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    //判断Tree1中是否有Tree2
    public boolean HasSubtree(TreeNode root1,TreeNode root2){
        boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                result = DoesTree1HaveTree2(root1,root2);
            }
            if(result == false){
                result = HasSubtree(root1.left,root2);
            }
            if(result == false){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }

    //在两个二叉树结点相等的情况下，Tree1是否有Tree2
    private boolean DoesTree1HaveTree2(TreeNode root1, TreeNode root2) {
        if(root2 == null){
            return true;
        }
        if(root1 == null){
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }
        return DoesTree1HaveTree2(root1.left,root2.left) && DoesTree1HaveTree2(root1.right,root2.right);
    }


}
