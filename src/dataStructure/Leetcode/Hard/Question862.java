package dataStructure.Leetcode.Hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yawen Cao
 * @data 2021/9/24 15:39
 */
public class Question862 {
    public static int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        int prefixArr[]=new int[n+1];
        int res=Integer.MAX_VALUE;

        int sum=0;
        Deque<Integer> deque=new ArrayDeque<Integer>();

        for(int i=1;i<n+1;i++){
            sum+=nums[i-1];
            prefixArr[i]=sum;
        }

        for(int i=0;i<n+1;i++){
            while(!deque.isEmpty() && prefixArr[i]<=prefixArr[deque.getLast()]) deque.removeLast();
            while(!deque.isEmpty() && prefixArr[i]-prefixArr[deque.peek()]>=k){
                res=Math.min(res,i-deque.peek());
                deque.poll();
            }
            deque.add(i);
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
