package datastructure;

import java.util.Hashtable;

//手写lru
class DLinkedList {
    String key; //键
    int value;    //值
    DLinkedList pre; //双向链表前驱
    DLinkedList next; //双向链表后继
}
public class LRU {
    private Hashtable<String,DLinkedList> cache = new Hashtable<String,DLinkedList>();
    private int count;
    private int capacity;
    private DLinkedList head, tail;
    public LRU(int capacity) {
        this.count = 0;
        this.capacity = capacity;
        head = new DLinkedList();
        head.pre = null;
        tail = new DLinkedList();
        tail.next = null;

        head.next = tail;
        tail.pre = head;
    }
    public int get(String key) {
        DLinkedList node = cache.get(key);
        if(node == null) return -1;
        this.moveToHead(node);
        return node.value;
    }
    public void set(String key,int value) {
        DLinkedList node = cache.get(key);
        if(node == null) {
            DLinkedList newNode = new DLinkedList();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            ++count;

            if(count>capacity) {
                DLinkedList tail = this.popTail();
                this.cache.remove(tail.key);
                --count;
            }
        }
        else {
            node.value = value;
            this.moveToHead(node);
        }
    }
    private void addNode(DLinkedList node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }
    private void removeNode(DLinkedList node) {
        DLinkedList pre = node.pre;
        DLinkedList next = node.next;
        pre.next = next;
        next.pre = pre;
    }
    private void moveToHead(DLinkedList node) {
        this.removeNode(node);
        this.addNode(node);
    }
    private DLinkedList popTail() {
        DLinkedList res = tail.pre;
        this.removeNode(res);
        return res;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DLinkedList node = head;
        while(node != null){
            sb.append(String.format("%s:%s ", node.key,node.value));
            node = node.next;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.set("1", 7);
        System.out.println(lru.toString());
        lru.set("2", 0);
        System.out.println(lru.toString());
        lru.set("3", 1);
        System.out.println(lru.toString());
        lru.set("4", 2);
        System.out.println(lru.toString());
        lru.get("2");
        System.out.println(lru.toString());
        lru.set("5", 3);
        System.out.println(lru.toString());
        lru.get("2");
        System.out.println(lru.toString());
        lru.set("6", 4);
        System.out.println(lru.toString());
        /*
         0ull:0 1:7 null:0
        null:0 2:0 1:7 null:0
        null:0 3:1 2:0 1:7 null:0
        null:0 4:2 3:1 2:0 null:0
        null:0 2:0 4:2 3:1 null:0
        null:0 5:3 2:0 4:2 null:0
        null:0 2:0 5:3 4:2 null:0
        null:0 6:4 2:0 5:3 null:0
         */
    }
}




