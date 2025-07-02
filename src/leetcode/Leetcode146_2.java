package leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Leetcode146_2 {
    public static void main(String[] args) {

    }
}
class LRUCache2{
    LinkedHashMap<Integer,Integer> map;
    int capacity;
    public LRUCache2(int capacity){
        map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key){
        if(map.containsKey(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }else{
            return -1;
        }
    }

    public void put(int key,int value){
        if(map.containsKey(key)){
            map.remove(key);
        }else if(map.size() == capacity){
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            Map.Entry<Integer, Integer> eldest = iterator.next();
            map.remove(eldest.getKey());
        }
        map.put(key,value);
    }
}
