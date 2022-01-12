package dataStructure.Leetcode.dp.Pack;

/**
 * @author Yawen Cao
 * @data 2021/12/4 10:00
 */
public class zeroOnePack {
    public int zoPack(int[] nums,int Volume,int number){
        int[][] dp=new int[number][Volume+1];
        for(int j=nums[0];j<=Volume;j++){
            dp[0][j]=nums[0];
        }
        for(int i=1;i<number;i++){
            for(int j=1;j<=Volume;j++){
                if(j>=nums[i]) dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[j]]+nums[j]);
            }
        }
        return dp[number-1][Volume];
    }
}
