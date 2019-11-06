public class offer10_1 {
    public int fib(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        int fibOne = 1;
        int fibTwo = 0;
        int fibN = 0;
        for(int i = 2 ;i <= n ;i++){
            fibN = fibOne + fibTwo;
            fibTwo = fibOne;
            fibOne = fibN;
        }
        return fibN;
    }

}
