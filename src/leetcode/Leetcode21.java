package leetcode;

public class Leetcode21 {
    //合并有序链表

    public static void main(String[] args) {
        Leetcode21 leetcode21 = new Leetcode21();
        ListNode node = leetcode21.mergeTwoLists(leetcode21.buildNode1(), leetcode21.buildNode2());
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode start = new ListNode();
        ListNode node = start;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                start.next = list2;
                list2 = list2.next;
            } else {
                start.next = list1;
                list1 = list1.next;
            }
            start = start.next;
        }
        if (list1 == null) {
            start.next = list2;
        }
        if (list2 == null) {
            start.next = list1;
        }
        return node.next;

    }

    public ListNode buildNode1() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        return node1;
    }

    public ListNode buildNode2() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
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

        ListNode(int val, Leetcode21.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
