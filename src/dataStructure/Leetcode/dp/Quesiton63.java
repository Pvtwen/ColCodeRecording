package dataStructure.Leetcode.dp;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/11/8 15:31
 */
public class Quesiton63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int n=obstacleGrid.length;
//        int m=obstacleGrid[0].length;
//        if(obstacleGrid[n-1][m-1]==1 || obstacleGrid[0][0]==1) return 0;
//        int[][] dp=new int[n][m];
//
//        for(int j=1;j<m;j++){
//            if(obstacleGrid[0][j]==1 || dp[0][j-1]==-1) dp[0][j]=-1;
//            else dp[0][j]=1;
//        }
//        for(int i=1;i<n;i++){
//            if(obstacleGrid[i][0]==1 || dp[i-1][0]==-1) dp[i][0]=-1;
//            else dp[i][0]=1;
//        }
//
//        for(int i=1;i<n;i++){
//            for(int j=1;j<m;j++){
//                if(obstacleGrid[i][j]==1) dp[i][j]=-1;
//                else{
//                    if(dp[i-1][j]==-1 && dp[i][j-1]==-1) dp[i][j]=-1;
//                    else if(dp[i-1][j]==-1) dp[i][j]=dp[i][j-1];
//                    else if(dp[i][j-1]==-1) dp[i][j]=dp[i-1][j];
//
//                    else dp[i][j]=dp[i-1][j]+dp[i][j-1];
//                }
//            }
//        }
//        return dp[n-1][m-1]==-1?0:dp[n-1][m-1];

        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        if(obstacleGrid[n-1][m-1]==1 || obstacleGrid[0][0]==1) return 0;
//        int[][] dp=new int[n][m];
        int[] dp=new int[m];

        for(int j=1;j<m;j++){
            if(obstacleGrid[0][j]==1 || dp[j-1]==-1) dp[j]=-1;
            else dp[j]=1;
        }
//        for(int i=1;i<n;i++){
//            if(obstacleGrid[i][0]==1 || dp[i-1][0]==-1) dp[i][0]=-1;
//            else dp[i][0]=1;
//        }

        for(int i=1;i<n;i++){
            if(obstacleGrid[i][0]==1 || dp[0]==-1) dp[0]=-1;
            else dp[0]=1;
            for(int j=1;j<m;j++){
                    if(obstacleGrid[i][j]==1) dp[j]=-1;
                    else{
                        if(dp[j]==-1 && dp[j-1]==-1) dp[j]=-1;
                        else if(dp[j]==-1) dp[j]=dp[j-1];
                        else if(dp[j-1]==-1) dp[j]=dp[j];
                        else dp[j]=dp[j]+dp[j-1];
                }
            }
        }
        return dp[m-1]==-1?0:dp[m-1];
    }
}
