public class offer25 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    //合并两个排序的链表
    //递归
    public ListNode merge(ListNode list1,ListNode list2){
        //只要有一个链表为空就输出另一个
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }

        //合并后链表的头节点
        ListNode mergerHead = null;
        if(list1.val < list2.val){
            mergerHead = list1;
            mergerHead.next = merge(list1,list2.next);
        }else {
            mergerHead = list2;
            mergerHead.next = merge(list1.next,list2);
        }
        return mergerHead;
    }

    //迭代
    public ListNode merge2(ListNode list1,ListNode list2){
        if(list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }
        ListNode mergerHead = null;
        if(list1.val < list2.val){
            mergerHead = list1;
            list1 = list1.next;
        }else {
            mergerHead = list2;
            list2 = list2.next;
        }

        ListNode tempNode = mergerHead;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                tempNode.next = list1;
                list1 = list1.next;
            }else {
                tempNode.next = list2;
                list2 = list2.next;
            }
            tempNode = tempNode.next;
        }

        if(list1 == null){
            tempNode.next = list2;
        }else {
            tempNode.next = list1;
        }
        return mergerHead;
    }

}
