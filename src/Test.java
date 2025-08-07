import java.util.*;
import java.util.stream.Collectors;

public class Test {

    //异位字符串
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

    //最长值连续的串长度
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 1;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int num1 = num;
                int temp = 1;
                while (set.contains(num1 + 1)) {
                    temp++;
                    num1++;
                }
                if (max <= temp) {
                    max = temp;
                }
            }
        }
        return max;
    }

    //移动0
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

    //盛水最多的容器
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

    //三数之和
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

    //接雨水
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

    //最长不重复子串
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

    //寻找字符串中匹配的异位词
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
            Arrays.sort(chars);
            str = new String(chars);
            if(str.equals(sort)){
                list.add(i);
            }
        }
        return list;
    }
    //获取链表的交点
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

    //翻转链表
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
    //链表是否回文
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
    //链表是否有环
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    //有环的交点
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
    //合并两个排序链表
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
        ListNode cur = new ListNode(-1);
        ListNode temp = cur;
        while (list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if(list1 == null){
            cur.next = list2;
        }else{
            cur.next = list1;
        }
        return temp.next;
    }

    //两个链表相加
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null){
            return null;
        }
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        int temp = 0;
        ListNode cur = new ListNode(0);
        ListNode head = cur;
        while (list1 != null && list2 != null){
            ListNode node = new ListNode( (list1.val + list2.val + temp) % 10);
            temp = (list1.val + list2.val + temp) / 10;
            cur.next = node;
            cur = cur.next;
            list1 = list1.next;
            list2 = list2.next;
        }
        while (list2 != null){
            ListNode node = new ListNode( (list2.val + temp) % 10);
            temp = (list2.val + temp) / 10;
            cur.next = node;
            cur = cur.next;
            list2 = list2.next;
        }

        while (list1 != null){
            ListNode node = new ListNode( (list1.val + temp) % 10);
            temp = (list1.val + temp) / 10;
            cur.next = node;
            cur = cur.next;
            list1 = list1.next;
        }
        if(temp != 0){
            ListNode node = new ListNode( temp);
            cur.next = node;
        }
        return head.next;
    }

    //移除第n个元素
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode start = new ListNode(0);
        ListNode slow = start,fast = start;
        start.next = head;
        for(int i = 0;i <= n;i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }

    //交换链表的顺序
    public ListNode swapPairs(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode pre = start;
        while(pre.next != null && pre.next.next != null){
            ListNode first = pre.next;
            ListNode second = first.next;
            ListNode third = second.next;
            pre.next = second;
            second.next = first;
            first.next = third;
            pre = pre.next.next;
        }
        return start.next;
    }
    //翻转m到n
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null){
            return null;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode pre = temp;
        ListNode start = head;
        for(int i = 1;i < m;i++){
            pre = start;
            start = start.next;
        }
        for(int i = 0;i < n - m;i++){
            ListNode node = start.next;
            start.next = node.next;
            node.next = pre.next;
            pre.next = node;
        }
        return temp.next;
    }
    //k个一组翻转
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode pre = temp;
        ListNode first = pre.next;
        ListNode cur = first;
        int count = 0;
        while(cur != null){
            count++;
            if(count == k){
                ListNode last = cur;
                pre.next = reverseNode(first,last);
                pre = first;
                first = pre.next;
                cur = first;
                count = 0;
            }else{
                cur = cur.next;
            }
        }
        return temp.next;
    }
    private ListNode reverseNode(ListNode first,ListNode last){
        while(first != last){
            ListNode cur = first;
            first = first.next;
            cur.next = last.next;
            last.next = cur;
        }
        return last;
    }
    //链表排序
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode mid = getMiddle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        return merge(left,right);

    }


    private ListNode getMiddle(ListNode head){
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(pre != null){
            pre.next = null;
        }

        return slow;
    }

    private ListNode merge(ListNode list1,ListNode list2){
        ListNode temp = new ListNode(0);
        ListNode dummy = temp;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
            }else{
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        temp.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
    //先序
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p!=null){
            if(p != null){
                stack.push(p);
                list.add(p.val);
                p = p.left;
            }else {
                p = stack.pop();
                p = p.right;
            }
        }
        return list;
    }
    //中序
    public List<Integer> iterativePre(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                p = stack.pop();
                list.add(p.val);
                p = p.right;
            }
        }
        return list;
    }
    //后序

    //最大深度
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    //翻转二叉树
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode newRoot = new TreeNode(root.val);
        newRoot.left = invertTree(root.right);
        newRoot.right = invertTree(root.left);
        return newRoot;
    }

    //对称二叉树
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return false;
        }
        return isSymmetric2(root.left,root.right);
    }

    public boolean isSymmetric2(TreeNode root1,TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 == null || root2 == null){
            return false;
        }
        return root1.val == root2.val && isSymmetric2(root1.left,root2.right) && isSymmetric2(root1.right,root2.left);
    }

    //二叉树的直径
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxDiameter = new int[1];
        getDepth(root, maxDiameter);
        return maxDiameter[0];
    }

    private int getDepth(TreeNode node, int[] maxDiameter) {
        if (node == null) {
            return 0;
        }
        int left = getDepth(node.left, maxDiameter);
        int right = getDepth(node.right, maxDiameter);
        maxDiameter[0] = Math.max(maxDiameter[0], left + right);
        return Math.max(left, right) + 1;
    }

    //二叉树的层次遍历
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int count = nodes.size();
            for(int i = 0;i < count;i++){
                TreeNode node = nodes.poll();
                l.add(node.val);
                if(node.left != null){
                    nodes.add(node.left);
                }
                if(node.right != null){
                    nodes.add(node.right);
                }
            }
            list.add(l);
        }
        return list;
    }
    //将有序数组转换为二叉搜索树
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        return dfsBST(nums,0,nums.length - 1);
    }

    private TreeNode dfsBST(int[] nums, int left, int right) {
        if(left > right){
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfsBST(nums,left,mid - 1);
        root.right = dfsBST(nums, mid + 1, right);
        return root;
    }

    //验证是否为二叉搜索树
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return false;
        }
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return isValidBST(node.left, min, node.val)
                && isValidBST(node.right, node.val, max);
    }

    //二叉搜索树中第 K 小的元素
    public int kthSmallest(TreeNode root, int k) {
        if(root == null || k <= 0){
            return 0;
        }
        int t = getSize(root.left);
        if(t > k - 1){
            return kthSmallest(root.left,k);
        }else if(t < k - 1){
            return kthSmallest(root.right,k - t - 1);
        }else {
            return root.val;
        }
    }

    public int getSize(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        return getSize(treeNode.left) + getSize(treeNode.right) + 1;
    }

    //重建二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < inorder.length;i++){
            map.put(inorder[i],i);
        }
        return rebuild(preorder,0,preorder.length - 1,0,map);

    }

    public TreeNode rebuild(int[] preorder,int preL,int preR,int inL,Map<Integer,Integer> map){
        if(preL > preR){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preL]);
        int leftSize = map.get(preorder[preL]) - inL;
        root.left = rebuild(preorder,preL + 1,preL + leftSize,inL,map);
        root.right = rebuild(preorder,preL + leftSize + 1,preR,inL + leftSize + 1,map);
        return root;
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            int count = nodes.size();
            for(int i = 0;i < count;i++){
                TreeNode node = nodes.poll();
                if(i == count - 1) {
                    list.add(node.val);
                }
                if(node.left != null){
                    nodes.add(node.left);
                }
                if(node.right != null){
                    nodes.add(node.right);
                }
            }
        }
        return list;
    }

    //二叉树展开为链表
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = right;
    }

    //求公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null && right == null){
            return null;
        }
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }

    //路径总和
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return pathSumFrom(root, targetSum)
                + pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum);
    }

    private int pathSumFrom(TreeNode node, long sum) {
        if (node == null) {
            return 0;
        }
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val)
                + pathSumFrom(node.right, sum - node.val);
    }

    //最大路径和
    public int maxPathSum(TreeNode root) {
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        maxPathSumHelper(root, maxSum);
        return maxSum[0];
    }

    private int maxPathSumHelper(TreeNode node, int[] maxSum) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxPathSumHelper(node.left, maxSum));
        int right = Math.max(0, maxPathSumHelper(node.right, maxSum));
        maxSum[0] = Math.max(maxSum[0], left + right + node.val);
        return Math.max(left, right) + node.val;
    }

    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int maxSize = 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i = 1;i < nums.length;i++){
            for(int j = 0;j < i;j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
                maxSize = Math.max(maxSize, dp[i]);

            }
        }
        return maxSize;
    }
    //和为 K 的子数组
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0, 1);

        for (int num : nums) {
            prefixSum += num;
            if (prefixSumMap.containsKey(prefixSum - k)) {
                count += prefixSumMap.get(prefixSum - k);
            }
            prefixSumMap.put(prefixSum, prefixSumMap.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    //滑动窗口的最大值
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0;i < nums.length;i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return res;
    }

    //最小覆盖子串
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }

        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }

        int left = 0, right = 0;
        int minLeft = 0, minLen = Integer.MAX_VALUE;
        int count = t.length();

        while (right < s.length()) {
            char c = s.charAt(right);
            if (map[c] > 0) {
                count--;
            }
            map[c]--;
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    minLeft = left;
                }
                char leftChar = s.charAt(left);
                map[leftChar]++;
                if (map[leftChar] > 0) {
                    count++;
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    //最大子数组和
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i = 1;i < nums.length;i++){
            if(dp[i - 1] > 0){
                dp[i] = dp[i - 1] + nums[i];
            }else{
                dp[i] = nums[i];
            }
            max = Math.max(dp[i],max);
        }
        return max;
    }

    //合并区间
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return new int[0][0];
        }
        // 按照区间的左端点从小到大排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        // 创建一个结果数组用于存储不重叠区间
        List<int[]> res = new ArrayList<>();
        // 当前区间初始值设置为第一个区间
        int[] cur = intervals[0];

        for(int i = 1;i < intervals.length;i++){
            // 如果当前区间的右端点大于等于下一个区间的左端点，则更新当前区间的右端点
            if(cur[1] >= intervals[i][0]){
                cur[1] = Math.max(cur[1],intervals[i][1]);
            }else {
                // 否则把当前区间加入到结果数组中
                res.add(cur);
                // 并将当前区间更新为下一个区间
                cur = intervals[i];
            }
        }
        res.add(cur);
        return res.toArray(new int[res.size()][2]);

    }
    //转轮数组
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) {
            return;
        }

        k = k % nums.length;
        if(k < 0) {
            k += nums.length;
        }

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //除自身以外数组的乘积
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        int[] res = new int[nums.length];
        int left = 1;
        for(int i = 0; i < nums.length;i++){
            res[i] = left;
            left = left * nums[i];
        }
        int right = 1;
        for(int i = nums.length - 1;i >=0;i--){
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }

    //缺失的第一个正数
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        int[] res = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0 && nums[i] <= nums.length){
                res[nums[i] - 1] = nums[i];
            }
        }
        for(int i = 0; i < res.length; i++){
            if(res[i] != i + 1){
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    //矩阵清零
    
    public void setZeroes(int[][] matrix) {
        if(matrix == null){
            return;
        }
        Set<Integer> tempI = new HashSet<>();
        Set<Integer> tempJ = new HashSet<>();
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[i].length;j++){
                if(matrix[i][j] == 0){
                    tempI.add(i);
                    tempJ.add(j);
                }
            }
        }

        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[i].length;j++) {
                if(tempI.contains(i)){
                    matrix[i][j] = 0;
                }
                if(tempJ.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    //螺旋矩阵
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }

        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse down
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top > bottom || left > right) break;

            // Traverse left
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
            }
            bottom--;

            // Traverse up
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
        return result;
    }
    //旋转图像
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return;

        }

        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last-offset];

                // right -> bottom
                matrix[last][last-offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top;
            }
        }
    }

    //搜索矩阵
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[row].length - 1;
        while(row < matrix.length && col >= 0){
            int temp = matrix[row][col];
            if(temp == target){
                return true;
            }else if(temp > target){
                col--;
            }else{
                row++;
            }

        }
        return false;
    }
    //全排列
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        backtrack(res,nums,new ArrayList<Integer>(),visited);
        return res;
    }

    private void backtrack(List<List<Integer>> res,int[] nums,ArrayList<Integer> temp,int[] visited){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(visited[i] == 1){
                continue;
            }
            visited[i] = 1;
            temp.add(nums[i]);
            backtrack(res,nums,temp,visited);
            visited[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }
    //求子集
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        result.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            backtrack(result, current, nums, i + 1);
            current.remove(current.size() - 1);
        }
    }

    //电话号码组合
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        letterCombinations2(digits, map, 0, "",list);
        return list;
    }
    public void letterCombinations2(String digits,Map<Character,String> map,int start,String str,List<String> list){
        if(str.length() == digits.length()){
            list.add(str);
            return;
        }
        if (start >= digits.length()) {
            return;
        }
        String temp = map.get(digits.charAt(start));
        if (temp == null) {
            return;
        }
        for(int j = 0;j < temp.length();j++){
            str = str + temp.charAt(j);
            letterCombinations2(digits, map, start + 1, str,list);
            str = str.substring(0,str.length() - 1);
        }
    }

    //组合总和
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2(res,new ArrayList<>(),candidates,target,0,0);
        return res;
    }
    public void combinationSum2(List<List<Integer>> res ,List<Integer> list,int[] candidates, int target,int sum,int start){
        if(target < sum){
            return;
        }
        if(target == sum){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i = start;i < candidates.length;i++){
            if(candidates[i] > target){
                break;
            }
            list.add(candidates[i]);
            sum = sum + candidates[i];
            combinationSum2(res,list,candidates,target,sum,i);
            list.remove(list.size() - 1);
            sum = sum - candidates[i];
        }

    }
    //括号组合
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        String str = "";
        generateParenthesis(res, str, n, n);
        return res;
    }

    private void generateParenthesis(List<String> res, String str, int left, int right) {
        if (left == 0 && right == 0) {
            res.add(str);
            return;
        }

        if (left > 0) {
            generateParenthesis(res, str + '(', left - 1, right);
        }
        if (right > left) {
            generateParenthesis(res, str + ')', left, right - 1);
        }
    }

    //单词搜索
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        return false;
    }

    public boolean exist2(char[][] board, String word,String res){
        return false;
    }

    //前 K 个高频元素
    public int[] topKFrequent(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
           if(map.get(nums[i]) != null){
               map.put(nums[i],map.get(nums[i]) + 1);
           }else{
               map.put(nums[i],1);
           }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue()
        );
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = pq.poll().getKey();
        }

        return result;
    }
    //前k大的数
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue(k);
        for(int i = 0;i < nums.length;i++){
            if(priorityQueue.size() < k){
                priorityQueue.add(nums[i]);
            }else if(nums[i] > priorityQueue.peek()){
                priorityQueue.poll();
                priorityQueue.add(nums[i]);
            }
        }
        return priorityQueue.peek();
    }



    public static void main(String[] args) {
        Test test = new Test();
        test.topKFrequent(new int[]{1,2},2);
    }


    public static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val){
            this.val = val;
            this.next = null;
        }
    }

    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        private TreeNode(int val){
            this.val = val;
        }
    }


}
