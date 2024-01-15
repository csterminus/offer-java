package leetcode;

public class Leetcode203 {
    //移除链表中给定的元素
      public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {
        Leetcode203 leetcode203 = new Leetcode203();
        ListNode node = leetcode203.removeElements(leetcode203.buildListNode(), 1);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
      }

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode first = dummy;
        while(head != null){
            if(head.val == val){
                first.next = head.next;
            }else {
                first = first.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public ListNode buildListNode(){
          ListNode node1 = new ListNode(1);
          ListNode node2 = new ListNode(1);
          ListNode node3 = new ListNode(6);
          ListNode node4 = new ListNode(3);
          ListNode node5 = new ListNode(4);
          ListNode node6 = new ListNode(5);
          ListNode node7 = new ListNode(6);
          node1.next = node2;
          node2.next = node3;
          node3.next = node4;
          node4.next = node5;
          node5.next = node6;
          node6.next = node7;
          return node1;
    }
}
