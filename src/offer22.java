public class offer22 {
    //链表的倒数第K个结点
    /**
     * 解题思路:设链表的长度为 N。设置两个指针 P1 和 P2，先让 P1 移动 K-1 步。在第k步时两个指针一起走
     * 此时让 P1 和 P2 同时移动，可以知道当 P1 移动到链表结尾时，P2 移动到第 N - K 个节点处，该位置就是倒数第 K 个节点。
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k){
        if(head == null || k == 0)
            return null;
        ListNode p1 = head;
        ListNode p2 = null;
        for(int i = 0; i < k-1; i++){
            if(p1.next != null)
                p1 = p1.next;
            else{
                return null;
            }
        }
        p2 = head;
        while(p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
