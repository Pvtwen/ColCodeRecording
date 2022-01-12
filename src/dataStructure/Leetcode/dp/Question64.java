package dataStructure.Leetcode.dp;

/**
 * @author Yawen Cao
 * @data 2021/11/8 16:40
 */
public class Question64 {
    public int minPathSum(int[][] grid) {
        // dp[i][j]: 从0，0 走到i,j的最短路径
        // 状态转移方程 dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp=new int[n][m];
        dp[0][0]=grid[0][0];
        // 处理1行
        for(int i=1;i<m;i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        // 处理1列
        for(int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}
