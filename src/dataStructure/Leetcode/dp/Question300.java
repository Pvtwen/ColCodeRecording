package dataStructure.Leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/13 14:45
 */
public class Question300 {
//    public static int lengthOfLIS(int[] nums) {
//        int length = nums.length;
//        int[] dp=new int[length];
//        dp[0]=1;
//        int res=Integer.MIN_VALUE;
//        for(int i=1;i<length;i++){
//            dp[i]=1;
//            for(int j=0;j<i;j++){
//                if(nums[i]>nums[j]){
//                    dp[i]=Math.max(dp[i],dp[j]+1);
//                }
//            }
//            res=Math.max(res,dp[i]);
//        }
//        return res;
//    }
    int max=0;
    public int lengthOfLIS(int[] nums) {
            dfs(nums,0,new ArrayList<>());
            return max;
    }
    public void dfs(int[] nums, int idx, List<Integer> ans){
        if(ans.size()>max) max=ans.size();
        if(idx==nums.length) return;
        ArrayList<Integer> copy = new ArrayList<>(ans);
        if(conditon(ans,nums[idx])){
            dfs(nums,idx+1,ans);
            copy.add(nums[idx]);
            dfs(nums,idx+1,copy);
        }else{
            dfs(nums,idx+1,ans);
        }
    }
    public boolean conditon(List<Integer> ans,int num){
        if(ans.size()==0) return true;
        for (Integer an : ans) {
            if(num<=an) return false;
        }
        return true;
    }
}
