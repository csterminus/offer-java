package offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class offer6 {
    /*
    题目：从尾到头打印链表
    题目描述：从尾到头反过来打印出每个结点的值。

     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    /*
    递归方法
    public static void printListFromTailToHead(ListNode listNode){
        if(listNode == null)
            return;
        printListFromTailToHead(listNode.next);
        System.out.println(listNode);
    }
    /*
    头插法
    利用链表头插法为逆序的特点。
    头结点和第一个节点的区别：
    头结点是在头插法中使用的一个额外节点，这个节点不存储值；
    第一个节点就是链表的第一个真正存储值的节点。
   */
    public List<Integer> printListFromTailToHead1(ListNode listNode){
        ListNode head = new ListNode(-1);
        while(listNode!=null){
            ListNode memo = listNode.next;
            //第一次循环head.next为null
            listNode.next = head.next;
            head.next = listNode;
            listNode = memo;
        }
        //构建ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        head = head.next;
        while(head!=null){
            ret.add(head.val);
            head = head.next;
        }
        return ret;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
        Stack<Integer> stack = new Stack<>();
        while(listNode!=null){
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while(!stack.isEmpty())
            ret.add(stack.pop());
        return ret;
     }

}
