package leetcode;

public class leetcode25 {

     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args) {
        leetcode25 leetcode25 = new leetcode25();
        ListNode node = leetcode25.reverseKGroup(leetcode25.buildListNode1(), 3);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        //指向翻转区间第一个节点的前一个节点
        ListNode pre = dummy;
        //指向翻转区间的第一个节点
        ListNode first = pre.next;
        //用于遍历的当前节点指针
        ListNode cur = first;
        int count = 0;
        while(cur != null){
            count++;
            if(count == k){
                ListNode last = cur;
                pre.next = reverseOneGroup(first,last);
                //注意此处的first节点已经是翻转后的最后一个节点
                pre = first;
                first = pre.next;
                cur = first;
                count = 0;
            }
            else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    private static ListNode reverseOneGroup(ListNode first,ListNode last){
         while(first != last){
             ListNode cur = first;
             first = first.next;
             cur.next = last.next;
             //last节点作为翻转后的第一个节点
             last.next = cur;
         }
         return last;
    }


    public ListNode buildListNode1(){
         ListNode node1 = new ListNode(1);
         ListNode node2 = new ListNode(2);
         ListNode node3 = new ListNode(3);
         ListNode node4 = new ListNode(4);
         ListNode node5 = new ListNode(5);
         node1.next = node2;
         node2.next = node3;
         node3.next = node4;
         node4.next = node5;
         return node1;
    }


}
