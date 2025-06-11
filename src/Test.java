import leetcode.Leetcode141;

import java.util.*;

public class Test {

    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);
            if(map.containsKey(s)){
                List<String> list = map.get(s);
                list.add(str);
                map.put(s,list);
            }else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s,list);
            }
        }
        return new ArrayList<>(map.values());
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 1;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int num = nums[i];
                int temp = 1;
                while (set.contains(num + 1)) {
                    temp++;
                    num++;
                }
                if (max <= temp) {
                    max = temp;
                }
            }
        }
        return max;
    }

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int left = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] != 0){
                nums[left] = nums[i];
                left++;
            }
        }
        for(int i = left;i < nums.length;i++){
            nums[i] = 0;
        }

    }

    public int maxArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left <= right){
            if(height[left] < height[right]){
                int temp = height[left] * (right - left);
                max = Math.max(temp,max);
                left++;
            }else{
                int temp = height[right] * (right - left);
                max = Math.max(temp,max);
                right--;
            }
        }
        return max;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        for(int i = 0;i < nums.length - 2;i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] + nums[right] == 0){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if(!resList.contains(list)){
                        resList.add(list);
                    }
                    left++;
                    right--;
                    while(left < right && (nums[left] == nums[left - 1])){
                        left++;
                    }
                    while(left < right && (nums[right] == nums[right + 1])){
                        right--;
                    }
                } else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }else{
                    left++;
                }

            }
        }
        return resList;
    }

    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        int lmax = 0;
        int rmax = 0;
        while(left < right){
            lmax = Math.max(height[left],lmax);
            rmax = Math.max(height[right],rmax);
            if(lmax < rmax){
                sum = sum + lmax - height[left];
                left++;
            }else {
                sum = sum + rmax - height[right];
                right--;
            }
        }
        return sum;

    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int max = 0;
        int left = 0;
        for(int i = 0;i < s.length();i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            max = Math.max(max,i - left + 1);
        }
        return max;
    }

    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.length() == 0){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        char[] chars = p.toCharArray();
        Arrays.sort(chars);
        String sort = new String(chars);
        for(int i = 0;i <= s.length() - p.length();i++){
            String str = s.substring(i,i + p.length());
            chars = str.toCharArray();
            str = new String(chars);
            if(str.equals(sort)){
                list.add(i);
            }
        }
        return list;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa != pb){
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null ){
            return null;
        }
        ListNode temp = new ListNode(-1);
        while(head != null){
            ListNode cur = head;
            head = head.next;
            cur.next = temp.next;
            temp.next = cur;
        }

        return temp.next;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null){
            return false;
        }
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            if(list.get(left) != list.get(right)){
                break;
            }else {
                left++;
                right--;
            }
        }
        if(left == right){
            return true;
        }
        if(left < right){
            return false;
        }
        return false;

    }
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = slow.next;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                slow = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }



    public class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }


}
