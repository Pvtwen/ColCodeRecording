package dataStructure.Compute;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Yawen Cao
 * @data 2021/11/9 9:25
 */
public class Game {
    Deque<int[]> queue=new ArrayDeque<>();
    int[][] arr=new int[10][10];
    int[][] copy=new int[10][10];
    public void init(int[][] arr){
        // 拷贝arr
        int n=arr.length;
        int m=arr[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                copy[i][j]=arr[i][j];
            }
        }
    }
    public void play(int x,int y,int value){
        arr[x][y]+=value;
        int[] option=new int[3];
        option[0]=x;option[1]=y;option[2]=value;
        queue.offer(option);
    }
    // 一次操作
    public void undo(){
        int time=1;
        while(!queue.isEmpty() && time!=0){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int value = poll[2];
            arr[x][y]-=value;
            time--;
        }
    }

    public void replay(){
//        int n=arr.length;
//        int m=arr[0].length;
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                arr[i][j]=copy[i][j];
//            }
//        }
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];
            int value = poll[2];
            arr[x][y]-=value;
        }
    }
}
