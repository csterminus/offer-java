package leetcode;

/**
 * 翻转链表
 */
public class Leetcode206 {

    public static void main(String[] args) {
        Leetcode206 leetcode206 = new Leetcode206();
        Leetcode206.ListNode node = leetcode206.reverseList(leetcode206.buildListNode());
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        if(head == null ){
            return null;
        }
        ListNode temp = new ListNode(-1);
        while(head != null){
            ListNode cur = head;
            head = head.next;
            cur.next = temp.next;
            temp.next = cur;
        }
        return temp.next;
    }

    public ListNode buildListNode() {
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
