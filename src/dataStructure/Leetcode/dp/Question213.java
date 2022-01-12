package dataStructure.Leetcode.dp;

/**
 * @author Yawen Cao
 * @data 2021/11/12 20:28
 */
public class Question213 {
    public int rob(int[] nums) {
        int length = nums.length;
        int[][] dp=new int[length][length];
        int res=Integer.MIN_VALUE;
        // 不偷窃最后一间 0,len-1
        dp[0][0]=0;dp[0][1]=nums[0];
        for(int i=1;i<length-1;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]);
            dp[i][1]=dp[i-1][0]+nums[i];
        }
        // dp[length-2][0]/[1]
        res=Math.max(dp[length-2][0],dp[length-2][1]);
        int[][] dp1=new int[length][length];
        dp1[1][0]=0;dp1[1][1]=nums[1];
        for(int i=2;i<length;i++){
            dp1[i][0]=Math.max(dp1[i-1][0],dp1[i-1][1]);
            dp1[i][1]=dp1[i-1][0]+nums[i];
        }
        int temp=Math.max(dp1[length-1][0],dp1[length-1][1]);
        res=Math.max(temp,res);
        return res;
    }
}
