package leetcode;

public class leetcode19 {
    //移除链表倒数第n个元素
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        leetcode19 leetcode19 = new leetcode19();
        ListNode head = leetcode19.buildListNodes();
        leetcode19.removeNthFromEnd(head,2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start,fast = start;
        slow.next = head;
        for(int i = 0;i <= n;i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

    public ListNode buildListNodes(){
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        listNode.next = listNode1;
        return listNode;
    }

}
