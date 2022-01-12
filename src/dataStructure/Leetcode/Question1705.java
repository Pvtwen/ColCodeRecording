package dataStructure.Leetcode;

import javax.swing.*;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Yawen Cao
 * @data 2021/12/25 10:18
 */
public class Question1705 {
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        int day=1;
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int num=0;
        while(!queue.isEmpty() || day<=n){
            // 判断当日有没有长出新平果
            if(day<=n && apples[day-1]>0) queue.offer(new int[]{apples[day-1],days[day-1]+day-1});
            // 从仓库筛选过期的苹果
            while(!queue.isEmpty() && queue.peek()[1]<day) queue.poll();
            // 吃苹果
            if(!queue.isEmpty()){
                int[] apple = queue.peek();
                apple[0]-=1;
                if(apple[0]==0) queue.poll();
            }
            num++;
            day++;
        }
        return num;
    }
//    public int eatenApples(int[] apples, int[] days) {
//        int n = apples.length;
//        int[][] arr=new int[n][2];
//        for(int i=0;i<n;i++){
//            arr[i]=new int[]{apples[i],i+days[i]};
//        }
//        // 小根堆 快过期的视频放到堆顶
//        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1] - o2[1];
//            }
//        });
//        int day=1;
//        int num = 0;
//        // 堆不为空 或者 还有苹果没长出来
//        while (!priorityQueue.isEmpty() || day <= n) {
//            // 还有苹果为长出
//            if (day < n) {
//                // 先看看当日的苹果
//                int i = arr[day - 1][0];
//                // 如果长出了苹果 就和快过期的苹果比较 看看谁先过期
//                if(i>0){
//                    int deadLine = arr[day - 1][1];
//                    int[] outDate = priorityQueue.peek();
//                    if(outDate!=null){
//                        int deadLine1 = outDate[1];
//                        // 如果堆顶苹果更晚过期 先吃长出来的苹果 （同时也能说明 堆顶苹果没过保质期)
//                        if(deadLine<deadLine1){
//                            arr[day-1][0]-=1;
//                            if(arr[day-1][0]>0) priorityQueue.offer(arr[day-1]);
//                        } else if (deadLine1 < deadLine) {
//                            // 要判断保质期
//                            // 如果没超过保质期
//                            if(outDate[1]>=day){
//                                outDate[0] -= 1;
//                                if (outDate[0] == 0) priorityQueue.poll();
//                                priorityQueue.offer(arr[day - 1]);
//                            }
//                            // 堆顶苹果过期了 扔掉 day，num不变
//                            else{
//                                priorityQueue.poll();
//                                continue;
//                            }
//                        }
//                        day++;
//                        num++;
//                    }// 如果队列为空
//                    else{
//                        num++;
//                        day++;
//                        arr[day-1][0]-=1;
//                        if(arr[day-1][0]>0) priorityQueue.offer(arr[day-1]);
//                    }
//                }
//            }
//            // 苹果已经完全长出来了
//            else{
//                int[] outDate = priorityQueue.peek();
//                if(outDate!=null){
//                    int i = outDate[1];
//                    // 如果没有过期
//                    if(i>=day) {
//                        outDate[0] -= 1;
//                        // 吃完了就扔扔掉
//                        if(outDate[0]==0) priorityQueue.poll();
//                    }
//                    // 如果过期了 直接扔掉 day不变 num不变
//                    else {
//                        priorityQueue.poll();
//                        continue;
//                    }
//                    num++;
//                    day++;
//                }
//            }
//        }
//        return num;
//    }
}
