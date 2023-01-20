package dataStructure.Leetcode.dp1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2022/2/10 15:50
 */
public class Q279 {
    // 记忆化搜
    int size;
    int sqrt;
    int[] rec;
    public int numSquares(int n) {
        size=n;
        sqrt= (int) Math.sqrt(n);
        rec=new int[size+1];
        return dfs(n);
    }
    public int dfs(int n){
        if(n==0) return 0;
        if(rec[n]!=0) return rec[n];
        int ans=n;
        for(int i=1;i<=sqrt;i++){
            if(n-i*i>=0) ans=Math.min(ans,dfs(n-i*i)+1);
        }
        rec[n]=ans;
        return rec[n];
    }
//    public int numSquares(int n) {
//        // dp[i][j]定义 背包容量为i时，使用前j个物体所需要的最小物体个数
//        int sqrt = (int) Math.sqrt(n);
//        int[][] dp=new int[n+1][sqrt+1];
//        for (int[] ints : dp) {
//            Arrays.fill(ints,Integer.MAX_VALUE);
//        }
//        // bound 背包容量为0时
//        for(int i=1;i<=sqrt;i++){
//            dp[0][i]=0;
//        }
//        for(int S=1;S<=n;S++){
//            int ans=Integer.MAX_VALUE;
//            for(int i=1;i<=sqrt;i++){
//                if(i*i<=S){
//                    dp[S][i]=Math.min(ans,dp[S-i*i][i]+1);
//                    ans=Math.min(ans,dp[S][i]);
//                }else {
//                    dp[S][i]=Math.min(dp[S][i],ans);
//                }
//            }
//        }
//        return dp[n][sqrt];
//    }
    // dp[i][j]定义 使用前i个物体时 背包容量为j，所需要的最小个数
//    public int numSquares(int n) {
//        int sqrt = (int) Math.sqrt(n);
//        int[][] dp=new int[sqrt+1][n+1];
//        for (int[] ints : dp) {
//            Arrays.fill(ints, (int) 1e5);
//        }
//        // 处理两个边界 一个是只有完全平方数1 另一个是`容量`为0
//        for(int i=1;i<=n;i++){
//            dp[1][i]=i;
//        }
//        for(int i=1;i<=sqrt;i++){
//            dp[i][0]=0;
//        }
//        for(int i=2;i<=sqrt;i++){
//            for(int j=0;j<=n;j++){
//                if(j>=i*i){
//                    dp[i][j]=Math.min(Math.min(dp[i-1][j-i*i]+1,dp[i-1][j]),dp[i][j-i*i]+1);
//                }else dp[i][j]=dp[i-1][j];
//            }
//        }
//        return dp[sqrt][n];
//    }
}
