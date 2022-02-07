package offer;

import java.util.Stack;

public class offer9 {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();
    public void push(int node){
        in.push(node);
    }

    public int pop() throws Exception{
        if(out.isEmpty())
            while(!in.isEmpty())
                out.push(in.pop());

         if(out.isEmpty())
             throw new Exception("queue is empty");
         return out.pop();
    }
}
