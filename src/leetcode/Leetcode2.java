package leetcode;

//链表相加
public class Leetcode2 {

    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        int temp = 0;
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        while (list1 != null && list2 != null){
            ListNode node = new ListNode( (list1.val + list2.val + temp) % 10);
            temp = (list1.val + list2.val + temp) / 10;
            cur.next = node;
            cur = cur.next;
            list1 = list1.next;
            list2 = list2.next;
        }
        while (list2 != null){

            ListNode node = new ListNode( (list2.val + temp) % 10);
            temp = (list2.val + temp) / 10;
            cur.next = node;
            cur = cur.next;
            list2 = list2.next;
        }

        while (list1 != null){
            ListNode node = new ListNode( (list1.val + temp) % 10);
            temp = (list1.val + temp) / 10;
            cur.next = node;
            cur = cur.next;
            list1 = list1.next;
        }
        if(temp != 0){
            ListNode node = new ListNode( temp);
            cur.next = node;
        }
        return head.next;

    }
    public class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }
}
