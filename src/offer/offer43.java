package offer;

public class offer43 {
    //1-n整数中1出现的次数
    /**
     * 从 1 至 10，在它们的个位数中，1出现了 1 次；
     * 从 1 至 100，在它们的十位数中，1出现了 10 次；
     * 从1至1000，在它们的百位数中，1出现了100次；
     *       依次类推，从 1 至 10 i，在它们的左数第二位(右数第 i 位)，1出现了 (10 i-1)次。这个规律很容易验证。
     *             我们以n=21345为例来使用这个规律。
     *       首先分析个位1出现了几次。从1~21340数字1总共出现了2134*1次，最后剩下21341、21342、21343、21344、21345，所有还出现1次数字1。所以个位共出现1的次数为2135次。
     *       接下来分析十位中1出现了几次。从1~21300数字1总共出现了213*10次，剩下的数字从 21301至 21345，它们最大的十位数是 4 > 1，所以还有10次。所以十位共出现2140次。
     *       接下来分析百位中1出现了几次。从1至21000数字1共出现了21*100次。剩下的数字是21001~21345，最大的百位数是3，大于1，所以还有100次。所以百位中1共出现了2200次。
     *       接下来分析千位中1出现了几次。从120000数字1共出现了2*1000次。剩下的数字是2000121345，最大的千位数是1，等于1，这种情况稍微比较复杂，因为它并不包括所有千位为1的数字，即1000个，这种情况取决于低位上的数字，为345+1=346次。最后总计2346次。
     *       接下来分析万位中1出现了几次。因为它是最高位了因此直接看最高位的数字，即2,2>1。很显然10000~19999中1在万位共出现了10000次。如果最高位等于1那就和上一步的思想一样。
     */
    public static int NumberOfBetween1AndN(int n){
        int count = 0;
        for(int i = 1;i <= n;i *= 10){
            int a = n / i,b = n % i;
            //之所以补8，是因为当i位为0，则a/10==(a+8)/10，
            //当i位>=2，补8会产生进位位，效果等同于(a/10+1)

            count += (a + 8) / 10 * i + ((a % 10 == 1) ? b + 1 : 0);
        }
        return count;
    }
    //暴力计数
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for(int i=0; i<=n; i++){
            int temp = i;
            //如果temp的任意位为1则count++
            while(temp!=0){
                if(temp%10 == 1){
                    count++;
                }
                temp /= 10;
            }
        }
        return count;
    }
    
}
