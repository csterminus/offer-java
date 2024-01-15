package leetcode;

public class Leetcode160 {
    //移除链表中给定的元素
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        if(headA.val == headB.val){
            return headA;
        }

        ListNode listNode = null;
        while(headA != null) {
            while(headB != null) {
                if (headA.val == headB.val) {
                    listNode = headA;
                    break;
                } else {
                    headB = headB.next;
                }
            }
            headA = headA.next;
        }
        return listNode;
    }










}
