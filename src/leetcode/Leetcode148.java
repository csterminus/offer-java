package leetcode;

public class Leetcode148 {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = getMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return merge(left,right);
    }

    private ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(fast!= null && fast.next!= null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // 如果prev不为空，则将prev的next指向null，即断开链表
        if (prev != null) {
            prev.next = null;
        }
        return slow;
    }

    private ListNode merge(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
    public static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

}
