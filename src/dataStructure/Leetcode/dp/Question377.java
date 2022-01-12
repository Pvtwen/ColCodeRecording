package dataStructure.Leetcode.dp;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/11/26 16:40
 */
public class Question377 {
    // dp
    public int combinationSum4(int[] nums, int target) {
        int length = nums.length;
        int[][] dp=new int[target+1][target+1];
        dp[0][0]=1;
        int ans=0;
        for(int i=1;i<=target;i++){
            for(int j=0;j<=target;j++){
                for (int num : nums) {
                    if(j>=num) dp[i][j]+=dp[i-1][j-num];
                }
            }
            ans+=dp[i][target];
        }
        return ans;
    }
//    static int ans=0;
//    static Set<List<Integer>> set=new HashSet<>();
//    public static int combinationSum4(int[] nums, int target) {
//        int length = nums.length;
//        ArrayList<Integer> list = new ArrayList<>();
//        for(int i=0;i<length;i++){
//            list.add(nums[i]);
//            dfs(nums,target,i,nums[i],list);
//            list.remove(list.size()-1);
//        }
//        return ans;
//    }
//    public static void dfs(int[] nums,int target,int idx,int curSum,List<Integer> list){
//        if(curSum==target) {
//            if(!set.contains(list)) ans++;
//            set.add(list);
//            return;
//        }
//        if(curSum>target) return;
//        for(int i=0;i<nums.length;i++){
//            list.add(nums[i]);
//            dfs(nums,target,i,curSum+nums[i],list);
//            list.remove(list.size()-1);
//        }
//    }
}
