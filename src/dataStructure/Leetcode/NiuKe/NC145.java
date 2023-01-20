package dataStructure.Leetcode.NiuKe;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/2/10 17:09
 */
public class NC145 {
//    public int knapsack (int V, int n, int[][] vw) {
//        // dp定义 剩余容量为i 前j个物体 装载的最大重量
//        // n^2个状态，n个决策(依赖于前面的j-1个物体 因为只有一个j).
//        // O(n^3)
//        int[][] dp=new int[V+1][n];
//        // bound剩余容量为0
//        for(int i=0;i<n;i++){
//            dp[0][i]=0;
//        }
//        for(int v=1;v<=V;v++){
//            for(int i=0;i<n;i++){
//                // 只有一个物品 直接判断
//                if(i==0){
//                    if(v>=vw[i][0]){
//                        dp[v][i]=vw[i][1];
//                    }
//                }else{
//                    if(v-vw[i][0]>=0) dp[v][i]=Math.max(dp[v][i-1],dp[v-vw[i][0]][i-1]+vw[i][1]);
//                    else dp[v][i]=dp[v][i-1];
//                }
//            }
//        }
//        return dp[V][n-1];
//    }
    public int knapsack (int V, int n, int[][] vw) {
        // dp定义 前n个物体 剩余容量为V 装载的最大重量
        int[][] dp = new int[n + 1][V + 1];
        //bound 剩余容量为0时
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            int vol = vw[i - 1][0];
            int weigh = vw[i - 1][1];
            for (int j = 1; j <= V; j++) {
                if (j >= vol) {
                    dp[i][j] = Math.max(dp[i][j], Math.max(dp[i - 1][j - vol] + weigh, dp[i - 1][j]));
                } else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][V];
    }
    // dp:剩余体积为V时，装载的最大价值
    public int knapsack1 (int V, int n, int[][] vw) {
        int[] dp=new int[V+1];
        int[][] p=new int[n+1][V+1];
        for(int i=1;i<=n;i++){
            for(int j=V;j>=vw[i-1][0];j--){
                if(dp[j-vw[i-1][0]]+vw[i-1][1]>dp[j]){
                    dp[j]=dp[j-vw[i-1][0]]+vw[i-1][1];
                    p[i][j]=1;
                }
            }
        }
        int r=V;
        for(int i=n;i>=1;i--){
            if(p[i][r]==1){
                System.out.println(i-1);
                r-=vw[i-1][0];
            }
        }
        return dp[V];
    }
    int[] tab;
    int[] visited;
    int[] steps=new int[(int) 1e5];
    int cur=0;
    public int knapsack2 (int V, int n, int[][] vw) {
        tab=new int[V+1];
        visited=new int[n];
        return dfs(V,n,vw);
    }
    public int dfs(int V,int n,int[][] vw){
        if(V<0) return (int) -1e5;
        if(V==0) return 0;
        int ans=0;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                visited[i]=1;
                ans=Math.max(ans,dfs(V-vw[i][0],n,vw)+vw[i][1]);
                visited[i]=0;
            }
        }
        tab[V]=ans;
        return tab[V];
    }
}
