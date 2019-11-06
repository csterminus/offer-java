public class offer18_2 {
    //删除重复的结点
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null || pHead.next == null)
            return pHead;
        ListNode next = pHead.next;
        if(pHead.val == next.val){
            while(next != null && pHead.val == next.val)
                next = next.next;
            return deleteDuplication(next);
        }else {
            pHead.next = deleteDuplication(pHead.next);
            return pHead;
        }
    }
}
