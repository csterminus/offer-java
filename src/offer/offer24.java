package offer;

public class offer24 {
    //翻转链表

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

        public ListNode reverse(ListNode head){
            //如果输入的链表为空，就直接返回空
            if(head == null){
                return null;
            }

            //如果输入的链表只有一个结点，就直接返回头结点
            if(head.next == null){
                return head;
            }

            //定义翻转后链表的头节点
            ListNode revNode = null;
            //当前节点
            ListNode curNode = head;
            ListNode preNode = null;

            while(curNode != null){
                ListNode nextNode = curNode.next;//记录当前节点的下一个节点
                curNode.next = revNode;//将当前节点的下一个节点翻转指向翻转链表的头节点
                preNode = curNode;
                curNode = nextNode;
            }
            return revNode;
        }
        //递归
        public ListNode ReverseList(ListNode head){
            if(head == null || head.next == null)
                return head;
            ListNode next = head.next;
            head.next = null;
            ListNode newHead = ReverseList(next);
            next.next = head;
            return newHead;
        }

        //头插法
        public ListNode ReverseList2(ListNode head){
            ListNode newList = new ListNode(-1);
            while(head != null){
                ListNode next = head.next;
                head.next = newList.next;
                newList.next = head;
                head = next;
            }
            return newList.next;
        }

}
