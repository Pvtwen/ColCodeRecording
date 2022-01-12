package dataStructure.Leetcode.Match265;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

/**
 * @author Yawen Cao
 * @data 2021/10/31 11:29
 */
public class Question5916 {
    public static int minimumOperations(int[] nums, int start, int goal) {
        HashSet<Integer> set=new HashSet<>();
        Queue<int[]> queue=new ArrayDeque<>();
        set.add(start);
        int length=nums.length;
        // value,step
        queue.offer(new int[]{start,0});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int value = poll[0];
            for(int i=0;i<length;i++){
                //+
                int i1 = value + nums[i];
                //-
                int i2=value-nums[i];
                //^
                int i3 = value ^ nums[i];
                if(i1==goal || i2==goal || i3==goal) return poll[1]+1;
                if(!set.contains(i1) && i1>=0 && i1<=1000){
                    queue.offer(new int[]{i1,poll[1]+1});
                    set.add(i1);
                }
                if(!set.contains(i2) && i2>=0 && i2<=1000){
                    queue.offer(new int[]{i2,poll[1]+1});
                    set.add(i2);
                }
                if(!set.contains(i3) && i3>=0 && i3<=1000){
                    queue.offer(new int[]{i3,poll[1]+1});
                    set.add(i3);

                }
            }
        }
        return -1;
    }
}
