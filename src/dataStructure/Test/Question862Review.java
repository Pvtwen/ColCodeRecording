package dataStructure.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yawen Cao
 * @data 2021/10/1 11:07
 */
public class Question862Review {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        int minLength=Integer.MAX_VALUE;
        int[] prefixArr=new int[n+1];
        for(int i=1;i<n+1;i++){
            sum+=nums[i-1];
            prefixArr[i]=sum;
        }
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=0;i<n+1;i++){
            while(!deque.isEmpty() && prefixArr[i]-prefixArr[deque.getFirst()]>=k){
                minLength=Math.min(minLength,i-deque.getFirst());
                deque.poll();
            }
            while(!deque.isEmpty() && prefixArr[i]<=prefixArr[deque.getLast()]){
                deque.removeLast();
            }
            deque.add(i);
        }

        return minLength;
    }
}
