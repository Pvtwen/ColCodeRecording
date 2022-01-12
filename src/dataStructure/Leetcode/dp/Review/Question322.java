package dataStructure.Leetcode.dp.Review;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/12/18 17:35
 */
public class Question322 {
    public int coinChange(int[] coins, int amount) {
        int length = coins.length;
        int[][] dp=new int[length+1][amount+1];
        dp[0][0]=1;
        for(int i=1;i<=length;i++){
            for(int j=1;j<=amount;j++){
                dp[i][j]=dp[i-1][j];
                for(int k=1;k<=j/coins[i-1];k++){
                    dp[i][j]+=dp[i-1][j-k*coins[i-1]];
                }
            }
        }
        return dp[length][amount];
    }
}
