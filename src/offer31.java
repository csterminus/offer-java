import java.util.Stack;

public class offer31 {
    //栈的压入、弹出队列
    public class StackSequence{
        public boolean isPopOrder(int[] pushA,int[] popA){
            int n = pushA.length;
            Stack<Integer> stack = new Stack<>();
            for(int pushIndex = 0,popIndex = 0; pushIndex < n;pushIndex++){
                stack.push(pushA[pushIndex]);
                while (popIndex < n && !stack.isEmpty() && stack.peek() == popA[popIndex]){
                    stack.pop();
                    popIndex++;
                }
            }
            return stack.isEmpty();
        }
    }
}
