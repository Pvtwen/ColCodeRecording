package dataStructure.Test;

import dataStructure.Queue.SeqQueue;
import dataStructure.Stack.SeqStack;

/**
 * @author 86153
 * @data 2021/6/10 19:09
 */
public class testHuiWen {
    public static void main(String[] args) throws Exception {
        String str="ABBA";
        huiWen2(str);
    }

    public static void huiWen(String str) throws Exception {
        int n=str.length();
        SeqStack seqStack = new SeqStack();
        SeqQueue queue = new SeqQueue();
        for(int i=0;i<n;i++){
            seqStack.push(str.charAt(i));
            queue.append(str.charAt(i));
        }

        for(int i=0;i<n;i++){
            Object pop = seqStack.pop();
            Object delete = queue.delete();
            if(!pop.equals(delete)){
                throw new Exception("不是回文");
            }
        }
        System.out.println("是回文");
    }

    public static void huiWen2(String str) throws Exception {
        int length = str.length();
        for(int i=0,j=length-i-1;i<length/2;i++,j--){
            if(!(str.charAt(i)==str.charAt(j))){
                throw new Exception("不是回文");
            }
        }
        System.out.println("是回文");
    }
}
