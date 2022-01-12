package dataStructure.Compute;

import java.util.ArrayDeque;
import java.util.Deque;
/**
 * @author Yawen Cao
 * @data 2021/11/9 9:33
 */
public class ComplicatedGame {
    Deque<int[]> queue=new ArrayDeque<>();
    int[] arr;
    // 0 +   1-   2 * 3/
    public void init(int[] arr){
        this.arr=arr;
    }
    public void play(int idx,int option,int value){
        if(option==0) arr[idx]+=value;
        if(option==1) arr[idx]-=value;
        if(option==2) arr[idx]*=value;
        if(option==3) arr[idx]/=value;
        int[] opt=new int[3];
        opt[0]=idx;opt[1]=option;opt[2]=value;
        queue.offer(opt);
    }
    public void undo(){
        int[] poll = queue.poll();
        int x = poll[0];
        int option = poll[1];
        int value = poll[2];
        option(x,option,value);
    }
    public void replay(){
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int option = poll[1];
            int value = poll[2];
            option(x,option,value);
        }
    }
    public void option(int idx,int option,int value){
        if(option==0) arr[idx]-=value;
        if(option==1) arr[idx]+=value;
        if(option==2) arr[idx]/=value;
        if(option==3) arr[idx]*=value;
    }
}
