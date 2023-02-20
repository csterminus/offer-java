package offer;

public class offer58 {
    public static void main(String[] args) {
        offer58 offer58 = new offer58();
        System.out.println(offer58.reverseLeftWords("lrloseumgh",6));
    }
    public String reverseLeftWords(String s, int n) {
        if(s == null || s.length() == 0 || n == 0){
            return null;
        }
        for(int i = 0;i < n;i++){
            s = s + s.charAt(i);
        }
        int count = 0;
        char[] str = s.toCharArray();
        for(int i = n; i < str.length;i++){
            str[count++] = s.charAt(i);
        }
        return new String(str,0,s.length() - n);
    }
}
