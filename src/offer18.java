public class offer18 {
    //在 O(1) 时间内删除链表节点
    /**
     * ① 如果该节点不是尾节点，那么可以直接将下一个节点的值赋给该节点，然后令该节点指向下下个节点，
     * 再删除下一个节点，时间复杂度为 O(1)。
     * ② 否则，就需要先遍历链表，找到节点的前一个节点，然后让前一个节点指向 null，时间复杂度为 O(N)。
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteNode(ListNode head,ListNode tobeDelete){
        if(head == null || tobeDelete == null)
            return null;
        if(tobeDelete.next!=null){
            //要删除的结点不是尾结点
            ListNode next = tobeDelete.next;
            tobeDelete.val = next.val;
            tobeDelete.next = next.next;
        }else {
            if(head == tobeDelete){
                //如果只有一个结点
                head = null;
        }else {
            ListNode cur = head;
            while(cur.next!=tobeDelete)
                cur = cur.next;
            cur.next = null;
        }
        }
        return head;
    }

}
