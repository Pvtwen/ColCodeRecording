package dataStructure.Leetcode.dp;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/11/17 15:58
 */
public class Question343 {
    //错误做法
//    public int integerBreak(int n) {
//        int[] dp=new int[n+1];
//        Arrays.fill(dp,1);
//        int res=Integer.MIN_VALUE;
//        for(int i=2;i<n;i++){
//            for(int j=1;j<=n;j++){
//                if(j>i){
//                    dp[j]=Math.max(dp[j],dp[j-i]*i);
//                    res=Math.max(res,dp[j]);
//                }
//            }
//        }
//        return res;
//    }

    //动态规划
//    public int integerBreak(int n) {
//        int[] dp=new int[n+1];
//        Arrays.fill(dp,1);
//        int res=1;
//        for(int i=2;i<n;i++){
//            for(int j=1;j<=n;j++){
//                if(i==j){
//                    dp[j]=Math.max(dp[j],j);
//                }
//                if(j>i){
//                    dp[j]=Math.max(dp[j],dp[j-i]*i);
//                }
//                res=Math.max(res,dp[j]);
//            }
//        }
//        return res;
//    }

    public int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=i;
        }
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[j]=Math.max(dp[j],dp[i-j]*j);
            }
        }
        return dp[n];
    }
}
