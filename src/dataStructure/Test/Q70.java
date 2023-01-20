package dataStructure.Test;

/**
 * @author Yawen Cao
 * @data 2022/2/12 10:33
 */
public class Q70 {
    // dp[n]:从第n层开始爬需要多少步数
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        if(n==1) return 1;
        if(n==2) return 2;
        dp[n]=1;dp[n-1]=2;dp[n-2]=3;
        for(int i=n-3;i>=0;i--){
            dp[i]=dp[i+1]+dp[i+2];
        }                    
        return dp[1];
    }
    //dp[n]:从第n层开始往下方案
    public int climbStairs1(int n) {
        int[] dp=new int[n+1];
        if(n==1) return 1;
        if(n==2) return 2;
        dp[1]=1;dp[2]=1;
        for(int i=3;i<=n+1;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n+1];
    }
    // 刷表 从第n层开始爬方案
    public int climbStairs2(int n) {
        int[] dp=new int[n+2];
        if(n==1) return 1;
        if(n==2) return 2;
        dp[n+1]=1;
        for(int i=n+1;i>=1;i--){
            if(i==1){
                dp[i-1]+=dp[i];
            }else{
                dp[i-1]+=dp[i];
                dp[i-2]+=dp[i];
            }
        }
        return dp[0];
    }
    // 刷表 从第n层往下走方案
    public int climbStairs3(int n) {
        int[] dp=new int[n+1];
        if(n==1) return 1;
        if(n==2) return 2;
        dp[1]=1;
        for(int i=1;i<=n-1;i++){
            if(i==n-1){
                dp[i+1]+=dp[i];
            }else{
                dp[i+1]+=dp[i];
                dp[i+2]+=dp[i];
            }
        }
        return dp[n];
    }
}
