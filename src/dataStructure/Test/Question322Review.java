package dataStructure.Test;

import javax.swing.*;
import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/11/6 11:02
 */
public class Question322Review {
//    static int[] visited;
//    static int[] coins;
//    static int[] d;
//    public static int coinChange(int[] coin, int amount) {
//        if(amount==0) return 0;
//        coins=coin;
//        d=new int[amount+1];
//        visited=new int[amount+1];
//        dp(amount);
//        return (d[amount]>amount)?-1:d[amount];
//    }
//    public static int dp(int amount){
//        if(amount==0) return 0;
//        if(visited[amount]==1) return d[amount];
//        visited[amount]=1;
//
//        d[amount]=1<<20;
//        for(int i=0;i<coins.length;i++){
//            if(amount>=coins[i]) d[amount]=Math.min(d[amount],dp(amount-coins[i])+1);
//        }
//        return d[amount];
//    }

    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 1;
        int length=coins.length;
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);

        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<length;j++){
                if(i>=coins[j]) dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
            }
        }
        return dp[amount]==amount?-1:dp[amount];
    }
}
