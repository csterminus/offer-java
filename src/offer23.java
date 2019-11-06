import java.util.List;

public class offer23 {
    /**
     * 链表中环的入口节点
     *
     * 思路：
     *      1.判断是否存在环，并找到快慢两个指针相遇的位置
     *      2.根据找到的这个相遇位置，统计环中节点的数目n，先让快指针走n步，然后快慢两个指针一起运动，快慢指针相遇时的节点就是环的入口节点
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead){
        //参数校验
        if(pHead == null) {
            return null;
        }
        //如果有环，第一个和第二个指针在环中相遇时的结点
        ListNode meetingNode = meetingNode(pHead);

        int ringLength = 0;//环的长度
        if(meetingNode != null){//如果存在环就求出环的长度
            ListNode tempNode = meetingNode;
            meetingNode = meetingNode.next;
            while(meetingNode != tempNode){
                ringLength ++;
                meetingNode = meetingNode.next;
            }
            ringLength ++;
        }else {
            return null;//如果不存在环就返回null
        }

        ListNode ahead = pHead;//第一个指针
        ListNode behind = pHead;//第二个指针

        while(ringLength > 0){
            ahead = ahead.next; //第一个指针现在链表上移动ringLength
            ringLength --;
        }

        while(ahead != behind){
            ahead = ahead.next;
            behind = behind.next;
        }
        return behind;
    }

    private ListNode meetingNode(ListNode head) {
        //参数校验
        if(head == null){
            return  null;
        }
        ListNode behind = head.next;//后面的指针

        //如果只有一个结点直接返回null
        if(behind == null) {
            return null;
        }
        ListNode ahead = behind.next;//前面的指针

        while(behind != null && ahead != null){
            if(behind == ahead){
                return ahead;
            }
            //behind指针在链表上移动一步
            behind = behind.next;
            //ahead指针在链表上移动两步
            ahead = ahead.next;
            if(ahead != null){
                ahead = ahead.next;
            }
        }
        return null;
    }
}
