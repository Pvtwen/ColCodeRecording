package dataStructure.Leetcode.dp.Pack;

/**
 * @author Yawen Cao
 * @data 2021/12/4 10:17
 */
public class fullPack {
    // nums:物品体积 value:物品价值
    public int full(int[] nums,int Volume,int number,int[] value){
        int[][] dp=new int[number][Volume+1];
        for(int i=nums[0];i<=Volume;i++){
            dp[0][i]=value[0]*(i/nums[0]);
        }
        for(int i=1;i<number;i++){
            for(int j=1;j<=Volume;j++){
                if(j>=nums[i]) dp[i][j]=Math.max(dp[i-1][j],dp[i][j-nums[i]]+value[i]);
            }
        }
        return dp[number-1][Volume];
    }
}
