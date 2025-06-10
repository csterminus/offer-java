package leetcode;

import java.util.*;
import java.util.stream.Collectors;

//字符串的异位词
public class Leetcode49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        List<String> list = Arrays.asList(strs);
        Map<String,List<String>> listMap = new HashMap<>();
        for(int i = 0;i < list.size();i++){
            char[] chars = list.get(i).toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            if(listMap.keySet().contains(sortStr)){
                List<String> subList = listMap.get(sortStr);
                subList.add(list.get(i));
                listMap.put(sortStr,subList);
            }else{
                List<String> subList = new ArrayList<>();
                subList.add(list.get(i));
                listMap.put(sortStr,subList);
            }
        }
        return new ArrayList<>(listMap.values());
    }
}
