package leetcode;

public class Leetcode_interview_02_07 {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
    public static void main(String[] args) {
        Leetcode_interview_02_07 leetcode_interview_02_07 = new Leetcode_interview_02_07();
        ListNode node = leetcode_interview_02_07.getIntersectionNode(null,null);
        if(node != null){
            System.out.println(node.val);
        }else {
            System.out.println(0);
        }
    }
    //判断链表是否相交
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode dummy1 = headA;
        ListNode dummy2 = headB;

        int lenA = 0;
        int lenB = 0;
        while(headA != null){
            lenA++;
            headA = headA.next;
        }
        while(headB != null){
            lenB++;
            headB = headB.next;
        }
        headA = dummy1;
        headB = dummy2;
        if(lenA < lenB){
            int tempLen = lenA;
            lenA = lenB;
            lenB = tempLen;

            ListNode tempNode = headA;
            headA = headB;
            headB = tempNode;
        }
        int gap = lenA - lenB;
        while(gap-- > 0){
            headA = headA.next;
        }
        while(headA != null ){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }


}
