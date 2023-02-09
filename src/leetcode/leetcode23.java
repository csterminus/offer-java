package leetcode;

public class leetcode23 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        leetcode23 leetcode23 = new leetcode23();
        ListNode[] nodes = new ListNode[]{leetcode23.buildNode1(), leetcode23.buildNode2(),leetcode23.buildNode3()};
        ListNode res = leetcode23.mergeKLists(nodes);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        ListNode start = lists[0];
        for(int i = 1;i < lists.length;i++){
            if(lists[i] == null){
                continue;
            }
            start = mergeTwoLists(start,lists[i]);
        }
        return start;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        ListNode start = new ListNode();
        ListNode node = start;

        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                start.next = list2;
                list2 = list2.next;
            }else {
                start.next = list1;
                list1 = list1.next;
            }
            start = start.next;
        }
        if(list1 == null){
            start.next = list2;
        }
        if(list2 == null){
            start.next = list1;
        }
        return node.next;
    }


    public ListNode buildNode1(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        return node1;
    }

    public ListNode buildNode2(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        return node1;
    }

    public ListNode buildNode3(){
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(6);
        node1.next = node2;
        return node1;
    }
}
