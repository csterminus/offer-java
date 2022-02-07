package offer;

public class offer5 {
    /*
    题目：替换空格
    题目描述：将一个字符串中的空格替换成 "%20"。
    Input:
    "A B"

    Output:
    "A%20B"
    解题思路
    在字符串尾部填充任意字符，使得字符串的长度等于替换之后的长度。因为一个空格要替换成三个字符（%20），因此当遍历到一个空格时，
    需要在尾部填充两个任意字符。
    令 P1 指向字符串原来的末尾位置，P2 指向字符串现在的末尾位置。P1 和 P2 从后向前遍历，当 P1 遍历到一个空格时，就需要令 P2
    指向的位置依次填充 02%（注意是逆序的），否则就填充上 P1 指向字符的值。
    从后向前遍是为了在改变 P2 所指向的内容时，不会影响到 P1 遍历原来字符串的内容。
     */
    public String replaceSpace(StringBuffer str){
        int p1 = str.length()-1;
        for(int i=0;i<=p1;i++)
            if(str.charAt(i)==' ')
                str.append("  ");
        int p2 = str.length()-1;
        while(p1>=0&&p2>p1){
            char c = str.charAt(p1--);
            if(c == ' '){
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }else {
                str.setCharAt(p2--,c);
            }
        }
        return str.toString();
    }
}
