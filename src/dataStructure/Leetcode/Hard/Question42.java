package dataStructure.Leetcode.Hard;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Yawen Cao
 * @data 2021/11/3 10:04
 */
public class Question42 {
    //    public int trap(int[] height) {
//        int length=height.length;
//        int left=0,right=length-1;
//        int maxLeft=0,maxRight=length-1;
//
//        int res=0;
//        while(left<=right){
//            if(height[left]<=height[right]){
//                if(height[left]>=height[maxLeft]) maxLeft=left;
//                else res+=height[maxLeft]-height[left];
//                left++;
//            }else{
//                if(height[right]>=height[maxRight]) maxRight=right;
//                else res+=height[maxRight]-height[right];
//                right++;
//            }
//        }
//        return res;
//    }cc

    // 单调栈
    public static int trap(int[] height) {
        // 存下标
        Deque<Integer> queue=new LinkedList<>();
        int length=height.length;
        int res=0;
        for(int i=0;i<length;i++){
            while(!queue.isEmpty() && height[i]>height[queue.getLast()]){
                int h = height[queue.getLast()];
                queue.removeLast();
                if(queue.isEmpty()){
                    break;
                }
                int h1 = height[queue.getLast()];
                int distance=i-queue.getLast()-1;
                int min=Math.min(h1,height[i]);
                res+=distance*(min-h);
            }
            queue.offer(i);
        }
        return res;
    }
}
