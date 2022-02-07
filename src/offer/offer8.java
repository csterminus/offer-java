package offer;

public class offer8 {
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
    //否则，向上找第一个左连接指向的数包含该结点的祖先结点
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
