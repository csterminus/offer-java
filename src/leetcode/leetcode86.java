package leetcode;

/**
 * @author chengshi
 * @date 2024/1/16 13:56
 */
public class leetcode86 {

    public static void main(String[] args) {
        leetcode86 leetcode86 = new leetcode86();
        ListNode node = leetcode86.partition(leetcode86.buildListNode(), 3);
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode smallHead = new ListNode(-1);
        ListNode smallHead2 = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigHead2 = bigHead;
        while (head != null) {
            ListNode cur = new ListNode(head.val);
            if (head.val < x) {
                smallHead.next = cur;
                smallHead = smallHead.next;
            } else {
                bigHead.next = cur;
                bigHead = bigHead.next;
            }
            head = head.next;
        }
        smallHead.next = bigHead2.next;
        return smallHead2.next;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }

        //TODO
        return null;
    }

    public ListNode buildListNode() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
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
