package dataStructure.Leetcode.dp1;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2022/2/6 10:15
 * 零钱兑换
 */
public class Q322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp=new int[amount+1];
        Arrays.fill(dp, (int) 1e8);
        // dp[i]:从节点i出发到节点0的最短路径长度
        dp[0]=0;
        int[] minCoins=new int[amount+1];
        for(int i=1;i<=amount;i++){
            for(int j=0;j<n;j++){
                if(i>=coins[j]){
                    if(dp[i]>dp[i-coins[j]]+1){
                        dp[i]=dp[i-coins[j]]+1;
//                        minCoins[i]=j;
                    }
                }
            }
        }
//        for(int i=0;i<n;i++){
//            for(int j=1;j<=amount;j++){
//                if(j>=coins[i]) dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
//            }
//        }

        print(coins,minCoins,amount);
        return dp[amount]>=1e8?-1:dp[amount];
    }
    public void print(int[] coins,int[] minCoins,int amount){
        while(amount>0){
            System.out.println(minCoins[amount]);
            amount-=coins[minCoins[amount]];
        }
    }
//    public int coinChange(int[] coins, int amount) {
//        dfs(coins,amount,0);
//        return ret==Integer.MAX_VALUE?-1:ret;
//    }
//    int ret=Integer.MAX_VALUE;
//    public void dfs(int[] coins,int amount,int sum){
//        if(amount<0){
//            return;
//        }
//        if(amount==0){
//            ret=Math.min(ret,sum);
//            return;
//        }
//        for (int coin : coins) {
//            dfs(coins,amount-coin,sum+1);
//        }
//    }
//    public int coinChange(int[] coins, int amount) {
//        int dfs = dfs(coins, amount);
//        return dfs>=1e5?-1:dfs;
//    }
//    HashMap<Integer,Integer> map=new HashMap<>();
//    public int dfs(int[] coins,int amount){
//        if(amount<0){
//            return (int) 1e7;
//        }
//        if(amount==0){
//            return 0;
//        }
//        if(map.containsKey(amount)) return map.get(amount);
//        int cur=Integer.MAX_VALUE;
//        for (int coin : coins) {
//            cur=Math.min(cur,1+dfs(coins,amount-coin));
//        }
//        map.put(amount,cur);
//        return cur;
//    }
}
