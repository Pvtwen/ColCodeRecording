package dataStructure.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Yawen Cao
 * @data 2022/1/12 10:45
 */
public class Question300Review {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        Stack<Integer> stack=new Stack<>();
        int ret=1;
        for(int i=0;i<length;i++){
            if(!stack.isEmpty() && nums[i]>stack.get(stack.size()-1)){
                stack.push(nums[i]);
            }
            else if(!stack.isEmpty() && nums[i]<stack.get(stack.size()-1)){
                // 找第一个大于等于nums[i]的值
                int l=0,r=stack.size()-1;
                while(l<=r){
                    int mid=(l+r)/2;
                    if(l==r) break;
                    else if(stack.get(mid)<nums[i]) l=mid+1;
                    else if(stack.get(mid)>=nums[i]) r=mid;
                }
                // l=r
                stack.set(l,nums[i]);
            }
            if(stack.isEmpty()) stack.push(nums[i]);
            ret=Math.max(ret,stack.size());
        }
        return ret;
    }
//    public int lengthOfLIS(int[] nums) {
//        int length = nums.length;
//        int[] dp=new int[length];
//        dp[0]=1;
//        int ret=1;
//        for(int i=1;i<length;i++){
//            dp[i]=1;
//            for(int j=i-1;j>=0;j--){
//                if(nums[i]>nums[j]) dp[i]=Math.max(dp[i],dp[j]+1);
//            }
//            ret=Math.max(ret,dp[i]);
//        }
//        return ret;
//    }
}
