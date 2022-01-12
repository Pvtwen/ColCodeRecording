package dataStructure.Compute;

/**
 * @author Yawen Cao
 * @data 2021/11/9 9:56
 */
public class Expression {
    public static int execute(int n){
//        int[] dp=new int[n+1];
//        dp[0]=0;
//        for(int i=1;i<=n;i++){
//            dp[i]=2*dp[i/2]+i;
//        }
//        System.out.println(dp[n]);
        return dfs(n);
    }
    public static int dfs(int n){
        if(n==0) return 0;
        return 2*dfs(n/2)+n;
    }
}
