package dataStructure.Review;

/**
 * @author Yawen Cao
 * @data 2021/11/25 17:03
 */
public class Question375 {
    public int getMoneyAmount(int n) {
        int[][] dp=new int[n+1][n+1];

        for(int len=2;len<=n;len++){
            for(int i=1;i+len-1<=n;i++){
                int r=i+len-1;
                dp[i][r]=Integer.MAX_VALUE;
                for(int j=i;j<=r;j++){
                    int cur = Math.max(dp[i][j - 1], dp[i + 1][j]) + j;
                    dp[i][r]=Math.min(dp[i][r],cur);
                }
            }
        }
        return dp[1][n];
    }
    //    static int N=20010;
//    static int[][] cache=new int[N][N];
//    public int getMoneyAmount(int n) {
//        int dfs = dfs(1, n);
//        return dfs;
//    }
//    public int dfs(int l,int r){
//        if(l>=r) return 0;
//        if(cache[l][r]!=0) return cache[l][r];
//        int ans=Integer.MAX_VALUE;
//        for(int i=l;i<=r;i++){
//            int lef = dfs(l, i - 1);
//            int rig = dfs(i + 1, r);
//            ans=Math.min(Math.max(lef,rig)+i,ans);
//        }
//        cache[l][r]=ans;
//        return cache[l][r];
//    }
}
