package dataStructure.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Yawen Cao
 * @data 2021/12/4 10:38
 */
public class Quesion322Review2 {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        int length = coins.length;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{amount,0});
        HashSet<Integer> set=new HashSet<>();
        set.add(amount);
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int money = poll[0];
            int number = poll[1];
            for (int coin : coins) {
                int i = money - coin;
                if(i==0) return number+1;
                else if(i>0){
                    if(set.contains(i)){
                        continue;
                    }
                    queue.offer(new int[]{i, number + 1});
                    set.add(i);
                }
            }
        }
        return -1;
    }
    // 超时
//    static HashMap<Integer,Integer> map=new HashMap<>();
//    public static int coinChange(int[] coins, int amount) {
//        if(amount==0) return 0;
//        int length = coins.length;
//        Deque<int[]> queue = new ArrayDeque<>();
//        queue.offer(new int[]{amount,0});
//        map.put(amount,0);
//        int res=Integer.MAX_VALUE;
//        while(!queue.isEmpty()){
//            int[] poll = queue.poll();
//            int money = poll[0];
//            int number = poll[1];
//            for (int coin : coins) {
//                int i = money - coin;
//                if(i==0) res=Math.min(res,number+1);
//                else if(i>0){
//                    if(map.containsKey(i)){
//                        Integer stepp = map.get(money);
//                        if(stepp<=number+1) continue;
//                    }
//                    queue.offer(new int[]{i,number+1});
//                    map.put(money,number+1);
//                }
//            }
//        }
//        return res==Integer.MAX_VALUE?-1:res;
//    }
    // k:面额 v:最少需要的硬币数量
//    static HashMap<Integer,Integer> map=new HashMap<>();
//    public static int coinChange(int[] coins, int amount) {
//        int dfs = dfs(coins, amount, amount);
//        return dfs==amount+1?-1:dfs;
//    }
//
//    public  static int dfs(int[] coins, int amount,int value) {
//        if(value==0) return 0;
//        if(map.containsKey(value))return map.get(value);
//        int ret=amount+1;
//        for(int i=0;i<coins.length;i++){
//            if(value>=coins[i]) ret=Math.min(ret,dfs(coins,amount,value-coins[i])+1);
//        }
//        map.put(value,ret);
//        return ret;
//    }
//    public static int coinChange(int[] coins, int amount) {
//        int length = coins.length;
//        int[] dp=new int[amount+1];
//        Arrays.fill(dp,amount+1);
//        dp[0]=0;
//        int res=amount+1;
//        for(int i=0;i<length;i++){
//            for(int j=coins[i];j<=amount;j++){
//                dp[j]=Math.min(dp[j],dp[j-coins[i]]+1);
//            }
//            res=Math.min(res,dp[amount]);
//        }
//        return res>amount?-1:res;
//    }

    // 二维数组
//    public int coinChange(int[] coins, int amount) {
//        int length = coins.length;
//        int[][] dp=new int[length][amount+1];
//        for(int i=0;i<length;i++){
//            for(int j=1;j<=amount;j++){
//                dp[i][j]=amount+1;
//            }
//        }
//        int res=amount+1;
//        for(int i=coins[0];i<=amount;i++){
//            dp[0][i]=Math.min(dp[0][i],dp[0][i-coins[i]]+1);
//        }
//        res=Math.min(res,dp[0][amount]);
//        for(int i=1;i<length;i++){
//            for(int j=1;j<=amount;j++){
//                if(j>=coins[i]) dp[i][j]=Math.min(dp[i-1][j],dp[i][j-coins[i]]+1);
//                else dp[i][j]=dp[i-1][j];
//            }
//            res=Math.min(res,dp[i][amount]);
//        }
//        return res==amount+1?-1:res;
//    }
}
