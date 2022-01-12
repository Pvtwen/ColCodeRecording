package dataStructure.Leetcode.dp.Review;

import dataStructure.Compute.OS.MemInit;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Yawen Cao
 * @data 2021/12/7 17:49
 */
public class Question300 {
//    public int lengthOfLIS(int[] nums) {
//        int length = nums.length;
//        int[] dp=new int[length];
//        dp[0]=0;
//        int ans=1;
//        for(int i=1;i<length;i++){
//            for(int j=i-1;j>=0;j--){
//                if(nums[i]>nums[j]) dp[i]=Math.max(dp[i],dp[j]+1);
//            }
//            ans=Math.max(ans,dp[i]);
//        }
//        return ans;
//    }

//    public static int lengthOfLIS(int[] nums) {
//        Stack<Integer> queue=new Stack<>();
//        int length = nums.length;
//        for (int i = 0; i < length; i++) {
//            if (!queue.isEmpty()) {
//                if(nums[queue.get(queue.size()-1)]<nums[i]) queue.add(i);
//                else{
//                    int l = 0, r = queue.size() - 1;
//                    while (l <= r) {
//                        int mid=(l+r)/2;
//                        Integer mIdx = queue.get(mid);
//                        if(l==r) break;
//                        else if(nums[i]>=nums[mIdx]) l=mid+1;
//                        else if(nums[i]<nums[mIdx]) r=mid;
//                    }
//                    queue.set(l,i);
//                }
//            }else queue.add(i);
//        }
//        return queue.size();
//    }

    public static int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp=new int[length];
        int cur=1;
        dp[0]=nums[0];
        for (int i = 1; i < length; i++) {
            if(nums[i]>dp[cur-1]){
                dp[cur]=nums[i];
                cur++;
            }else{
                int l = 0, r = cur - 1;
                while (l <= r) {
                    int mid = (l + r) / 2;
                    if (l == r) break;
                    else if (dp[mid] >= nums[i]) r = mid;
                    else l = mid + 1;
                }
                dp[l] = nums[i];
            }
        }
        return cur;
    }
}
