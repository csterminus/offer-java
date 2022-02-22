package offer;

import java.util.Stack;

public class offer30 {
    //包含min函数的栈
    /**
     * 自定义栈的数据结构 ：请在该类型中实现一个能够得到栈的最小值的min函数。在该栈中调用min、push、pop的时间复杂度为o(1)
     */
    public class CustomStack{
        //数据栈
        Stack<Integer> dataStack = new Stack<>();
        //辅助栈
        Stack<Integer> minStack = new Stack<>();
        //最小值
        int minValue = 0;

        //进栈
        public void push(int node){
            dataStack.push(node);

            if(minStack.isEmpty()){
                minValue = node;
            }else {
                if(minValue > node){
                    minValue = node;
                }
            }
            minStack.push(minValue);
        }

        //出栈
        public void pop(){
            if(!dataStack.isEmpty() && !minStack.isEmpty()){
                dataStack.pop();
                minStack.pop();
                if(!minStack.isEmpty()){
                    minValue = minStack.peek();
                }else {
                    minValue = 0;
                }
            }
        }

        //取栈顶值
        public int top(){
            if(!dataStack.isEmpty()){
                return dataStack.peek();
            }
            return 0;
        }

        public int min(){
            return minValue;
        }


    }
}
