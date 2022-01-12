package dataStructure.Stack;

import java.util.Arrays;

public class SeqStack implements myStack {
    final int defalutSize=10;
    int top; //栈顶
    private Object[] stack; //数组对象
    int maxStackSize;   //最大数据元素个数

    //无参 默认10
    public SeqStack(){
        stack=new Object[defalutSize];
        maxStackSize=defalutSize;
        top=0;
    }

    //有参 size
    public SeqStack(int size){
        stack=new Object[size];
        maxStackSize=size;
        top=0;
    }

    @Override
    public void push(Object object) throws Exception {
        //满
        if(maxStackSize==top){
            maxStackSize=maxStackSize+defalutSize;
            stack = Arrays.copyOf(stack, maxStackSize);
        }
        stack[top++]=object;
    }

    @Override
    public Object pop() throws Exception {
        if(top==0){
            throw new Exception("空栈");
        }
        top--;
        return stack[top];
    }

    @Override
    public Object getTop() throws Exception {
        if(top==0){
            throw new Exception("空栈");
        }
        return stack[top-1];
    }

    @Override
    public boolean notEmpty() {
        return top==0?false:true;
    }

}
