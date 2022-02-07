package offer;

public class offer36 {
    //二叉搜索树与双向链表
    /**
     * 按照中序遍历的顺序，当我们遍历转换到根节点（值为10的结点）时，
     * 它的左子树已经转换成一个排序的链表了，并且处在链表中的最后一个
     * 结点是当前值的最大的结点。我们把值为8的结点与根节点链接起来，
     * 此时链表中的最后一个结点是10了。接着我们去遍历转换右子树，
     * 并把根节点和右子树最小的结点链接起来。至于怎么去转换它的左子树和右子树，
     * 由于遍历和转换过程是一样的，我们自然的想到了递归。
     */
    public class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public class BinaryTreeConvert{
        BinaryTreeNode head = null;
        BinaryTreeNode realHead = null;
        public BinaryTreeNode Convert(BinaryTreeNode pRootOfTree){
            ConvertSub(pRootOfTree);
            return realHead;
        }
        private void ConvertSub(BinaryTreeNode pRootOfTree){
            if(pRootOfTree == null)
                return;
            ConvertSub(pRootOfTree.left);
            if(head == null){
                head = pRootOfTree;
                realHead = pRootOfTree;
            }else {
                head.right = pRootOfTree;
                pRootOfTree.left = head;
                head = pRootOfTree;
            }
            ConvertSub(pRootOfTree.right);
        }
    }

}
