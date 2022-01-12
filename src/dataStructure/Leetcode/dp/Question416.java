package dataStructure.Leetcode.dp;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/12/4 9:10
 */
public class Question416 {
    public static boolean canPartition(int[] nums) {
        int length = nums.length;
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if(sum%2!=0) return false;
        int[][] dp=new int[length][sum/2+1];
        for(int i=1;i>=nums[0] && i<=sum/2;i++){
            dp[0][i]=nums[0];
        }
        if(dp[0][sum/2]==sum/2) return true;
        for(int i=1;i<length;i++){
            for(int j=1;j<=sum/2;j++){
                if(j>=nums[i]) dp[i][j]=Math.max(dp[i-1][j-nums[i]]+nums[i],dp[i-1][j]);
                else dp[i][j]=dp[i-1][j];
            }
            if(dp[i][sum/2]==sum/2) return true;
        }
        return false;
    }
}
