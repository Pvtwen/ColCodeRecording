package dataStructure.Leetcode.dp;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/11/8 15:05
 */
public class Question62 {
    public int uniquePaths(int m, int n) {
        // dp[i][j]：到i ，j的路径
//        int[][] dp=new int[m+1][n+1];

        // 滚动数组
        int[] dp=new int[n+1];

        Arrays.fill(dp,1);

        for(int i=2;i<=m;i++){
            for(int j=2;j<=n;j++){
                dp[j]=dp[j]+dp[j-1];
            }
        }
        return dp[n];
//        for(int i=1;i<=m;i++){
//            for(int j=1;j<=n;j++){
//                if(i-1<1||j-1<1){
//                    dp[i][j]=1;
//                }
//                if(i-1>=1 && j-1>=1){
//                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
//                }
//            }
//        }
//        return dp[m][n];
    }
}
