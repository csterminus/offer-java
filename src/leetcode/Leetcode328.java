package leetcode;

/**
 * @author chengshi
 * @date 2024/5/7 10:11
 */
public class Leetcode328 {
    public static void main(String[] args) {

    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode evan = head.next;
        ListNode evanHead = evan;
        while (evan != null && evan.next != null) {
            odd.next = evan.next;
            odd = odd.next;
            evan.next = odd.next;
            evan = evan.next;
        }
        odd.next = evanHead;
        return head;
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
