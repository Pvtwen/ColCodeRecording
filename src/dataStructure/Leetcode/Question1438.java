package dataStructure.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yawen Cao
 * @data 2021/9/24 17:02
 */
public class Question1438 {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> deque1=new ArrayDeque<>();
        Deque<Integer> deque2=new ArrayDeque<>();
        // 因为题干要求 子数组中最大值与最小值之差  最大值和最小值都有可能不是子数组的左边界，所以为了方便后续计算滑动窗口的长度
        // 需要设置滑动窗口的左右边界 left right
        // 对比862 因为其滑动窗口的左边界就是他的最小值 所以不再需要设置左边界变量 直接deque.peek()即可得数组的长度
        int left=0,right=0;
        int n=nums.length;
        int len=1;

        while(right<n){
            while(!deque1.isEmpty() && nums[deque1.getLast()]<nums[right]) deque1.removeLast();
            while(!deque2.isEmpty() && nums[deque2.getLast()]>nums[right]) deque2.removeLast();

            deque1.add(right);
            deque2.add(right);

            while(!deque1.isEmpty() && !deque2.isEmpty() && nums[deque1.peek()]-nums[deque2.peek()]>limit){
                if(left==deque1.peekFirst()) deque1.poll();
                if(left==deque2.peekFirst()) deque2.poll();
                left++;
            }
            len=Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
}
