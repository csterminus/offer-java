package leetcode;

public class leetcode24 {
    //两两交换链表中的节点
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {
        leetcode24 leetcode24 = new leetcode24();
        ListNode node = leetcode24.swapPairs(leetcode24.buildNode1());
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode pre = preHead;
        while(pre.next != null && pre.next.next != null){
            ListNode first = pre.next;
            ListNode second = first.next;
            ListNode third = second.next;
            pre.next = second;
            second.next = first;
            first.next = third;
            pre = pre.next.next;
        }
        return preHead.next;
    }

    public ListNode buildNode1(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        return node1;
    }
}
