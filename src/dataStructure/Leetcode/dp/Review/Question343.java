package dataStructure.Leetcode.dp.Review;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/12/14 10:35
 */
public class Question343 {
    // 完全背包
    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int[] dp=new int[n+1];
        // 容量
        int ret=1;
        Arrays.fill(dp,1);
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                dp[j]=Math.max(dp[j],dp[j-i]*i);
            }
        }
        return dp[n];
    }
}
