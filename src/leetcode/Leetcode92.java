package leetcode;

public class Leetcode92 {
    public class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Leetcode92 leetcode92 = new Leetcode92();
        ListNode node = leetcode92.reverseBetween(leetcode92.build(),2,4);
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n){
        if(head == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preStart = dummy;
        ListNode start = head;
        for(int i = 1;i < m;i++){
            preStart = start;
            start = start.next;
        }
        for(int i = 0;i < n - m;i++){
            ListNode temp = start.next;
            start.next = temp.next;
            temp.next = preStart.next;
            preStart.next = temp;
        }
        return dummy.next;
    }

    public ListNode build(){
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        node.next = node1;
        node1.next = node2;
        node2.next = node3;
        node4.next = node4;
        return node;
    }
}
