package offer;

import java.util.Date;

public class offer37 {
    //序列化二叉树
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    private String deserializeStr;
    public String Serialize(TreeNode root){
        if(root == null)
            return "#";
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    public TreeNode Deserialize(String str){
        deserializeStr = str;
        return Deserialize();
    }

    private TreeNode Deserialize(){
        if(deserializeStr.length() == 0)
            return null;
        //indexof返回第一次出现此字符的索引
        int index = deserializeStr.indexOf(" ");
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0,index);
        deserializeStr = index == -1 ? "" :deserializeStr.substring(index + 1);
        if(node.equals("#"))
            return null;
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }

}
