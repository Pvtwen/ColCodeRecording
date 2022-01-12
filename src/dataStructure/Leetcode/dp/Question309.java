package dataStructure.Leetcode.dp;

/**
 * @author Yawen Cao
 * @data 2021/11/13 15:45
 */
public class Question309 {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[][] dp=new int[length][length];
        dp[0][0]=-prices[0];dp[0][1]=0;dp[0][2]=0;
        for(int i=1;i<length;i++){
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][2]-prices[i]);
            dp[i][1]=dp[i-1][0]+prices[i];
            dp[i][2]=dp[i-1][2];
        }
        return Math.max(dp[length-1][1],dp[length-1][2]);
    }
}
