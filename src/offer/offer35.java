package offer;

public class offer35 {
    //复杂链表的复制
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }
    public class copyList{
        public RandomListNode Clone(RandomListNode pHead){
            if(pHead == null){
                return null;
            }

            //创建复制后的链表
            cloneNodes(pHead);
            //连接复制节点的兄弟节点
            connectSibling(pHead);
            //将原始节点和复制节点分开
            return reconnectNodes(pHead);
        }

        //复制节点
        public void cloneNodes(RandomListNode head){
            RandomListNode nowNode = head;
            while(nowNode != null){
                RandomListNode clonedNode = new RandomListNode(nowNode.label);
                clonedNode.next = nowNode.next;
                nowNode.next = clonedNode;

                nowNode = clonedNode.next;
            }
        }

        //连接复制节点的兄弟节点
        public void connectSibling(RandomListNode head){
            RandomListNode nowNode = head;
            while(nowNode != null){
                RandomListNode cloned = nowNode.next;
                if(nowNode.random != null){
                    cloned.random = nowNode.random.next;
                }
                nowNode = cloned.next;
            }
        }

        //将原始节点和复制节点分开
        public RandomListNode reconnectNodes(RandomListNode head){
            RandomListNode clonedHead = head.next;
            RandomListNode nowNode = head;
            while(nowNode != null){
                RandomListNode clonedNode = nowNode.next;

                nowNode.next = clonedNode.next;
                clonedNode.next = clonedNode.next == null ? null : clonedNode.next.next;
                nowNode = nowNode.next;
            }
            return clonedHead;
        }
    }

}
