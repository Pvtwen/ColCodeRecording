package dataStructure.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/11/7 16:39
 */
public class Question322Review1 {
//    static int[] dp;
//    static int n;
//    public static int coinChange(int[] coins, int amount) {
//        dp=new int[amount+1];
//        Arrays.fill(dp,-1);
//        n=amount;
//        int dfs = dfs(coins, amount);
//        return dfs>amount?-1:dfs;
//    }
//
//    public static int dfs(int[] coins,int amount){
////        if(map.containsKey(amount)) return map.get(amount);
//        if(dp[amount]>=0) return dp[amount];
//        if(amount==0) {
//            dp[amount]=0;
//             return dp[amount];
//        }
//
//        int number=n+1;
//        int length=coins.length;
//        for(int i=0;i<length;i++){
//            int value = coins[i];
//            if(amount>=value) {
//                number=Math.min(number, dfs(coins,amount-value)+1);
//                dp[amount]=number;
//            }
//        }
//
//        return dp[amount];
//    }

    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int length=coins.length;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        // dp[i] 以状态amount=i为结束点的最短边权路径
        for(int i=1;i<amount;i++){
            for(int j=0;j<length;j++){
                if(j>=coins[i]) dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
