package offer;

public class offer8 {
    /**
     * 获取二叉树的下一个节点
     * 给定二叉树和其中一个节点（唯一参数），找到中序遍历序列的下一个节点
     * 如果一个节点有右子树，那么它的下一个节点就是它的右子树中的最左子节点。
     *
     * 如果节点没有右子树的情形，并且该节点是它父节点的左子节点，那么它的下一个节点就是它的父节点。
     *
     * 如果一个节点既没有右子树，并且它还是它父节点的右子节点，
     * 那么这种情形就比较复杂。我们可以沿着指向父节点的指针一直向上遍历，
     * 直到找到一个是它父节点的左子节点的节点。如果这样的节点存在，那么这个节点的父节点就是我们要找的下一个节点。
     * 如果当前节点没有父节点，那所求的下一个节点不存在，返回null.
     * 如果输入节点是他父节点的左孩子，那他的父节点就是所求的下一个节点
     * 如果输入节点是他父节点的右孩子，那就需要将输入节点的父节点作为新的当前节点
     *
     */
    public class TreeLinkNode{
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;//指向父节点

        TreeLinkNode(int val){
            this.val = val;
        }
    }
    //如果一个结点的右子树不为空，那么该节点的下一个节点是右子树最左的结点
    //否则，向上找第一个左子树指向的树包含该结点的祖先结点
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode.right != null){
            TreeLinkNode node = pNode.right;
                while(node.left != null){
                node = node.left;
            }
            return node;
        }else {
            while (pNode.next != null){
                TreeLinkNode parent = pNode.next;
                if(parent.left == pNode)
                    return parent;
                pNode = pNode.next;
            }
        }
        return null;
    }



}
