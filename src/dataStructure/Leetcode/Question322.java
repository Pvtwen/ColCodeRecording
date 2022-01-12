package dataStructure.Leetcode;

import javax.swing.*;
import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/10/23 16:59
 */
public class Question322 {
//    public int coinChange(int[] coins, int amount) {
//        if(amount==0) return 0;
////        int[] dp=new int[amount+1];
//
//        int length=coins.length;
//        int[] dp=new int[amount+1];
//        int flag=-1;
//        Arrays.fill(dp,amount+1);
//        for(int i=0;i<length;i++){
//            if(amount>=coins[i]) {
//                dp[coins[i]]=1;
//                flag=1;
//            }
//        }
//        if(flag==-1) return -1;
//        for(int i=1;i<=amount;i++){
//            for(int j=1;j<=i/2;j++){
//                if(dp[j]==Integer.MAX_VALUE || dp[i-j]==Integer.MAX_VALUE) continue;
//                dp[i]=Math.min(dp[i],dp[j]+dp[i-j]);
//            }
//        }
//        return dp[amount]==amount+1?-1:dp[amount];
//    }

//    public static int coinChange(int[] coins, int amount) {
//        if(amount==0) return 0;
//        int[] dp=new int[amount+1];
//        Arrays.fill(dp,amount+1);
//
//        int length=coins.length;
//        dp[0]=0;
//        for(int i=1;i<=amount;i++){
//            for(int j=0;j<length;j++){
//                if(i-coins[j]>=0)
//                    dp[i]=Math.min(dp[i],dp[i-coins[j]]+1);
//            }
//        }
//
//        return dp[amount]==amount+1?-1:dp[amount];
//    }

    public int coinChange(int[] coins,int amount){
        Set<Integer> set=new HashSet<>();
        Queue<Integer> queue=new ArrayDeque<>();

        queue.offer(0);
        int level=0;

        int length=coins.length;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i=0;i<size;i++){
                Integer poll = queue.poll();
                for(int j=0;j<length;j++){
                    int sum=poll+coins[j];
                    if(sum==amount) return level;
                    if(sum<amount && !set.contains(sum)){
                        set.add(sum);
                        queue.offer(sum);
                    }
                }
            }
        }
        return -1;
    }
}
