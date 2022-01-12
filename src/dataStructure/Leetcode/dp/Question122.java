package dataStructure.Leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/11 16:15
 */
public class Question122 {
//    int res=Integer.MIN_VALUE;
//    public int maxProfit(int[] prices) {
////        int n=prices.length;
////        int[][] dp=new int[n][2];
////        dp[0][0]=0;dp[0][1]=-prices[0];
////
////        for(int i=1;i<n;i++){
////            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
////            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
////        }
////        return Math.max(dp[n-1][0],dp[n-1][1]);
//        dfs(prices,0,0,0);
//
//        return res;
//    }
//
//    // status=0:不持股 1:持股
//    // 图中每个节点的入度为1，所以不用map保存状态
//    public void dfs(int[] prices,int idx,int profit,int status){
//        if(idx==prices.length-1){
//            if(status==1) res=Math.max(res,profit+prices[idx]);
//            else res=Math.max(res,profit);
//            return;
//        }
//        if(status==0){
//            dfs(prices,idx+1,profit-prices[idx],1);
//            dfs(prices,idx+1,profit,0);
//        }else if(status==1){
//            dfs(prices,idx+1,profit,1);
//            dfs(prices,idx+1,profit+prices[idx],0);
//        }
//    }

    //滚动数组
//    public int maxProfit(int[] prices) {
//        int n=prices.length;
//        int temp;
//        int q=0,p=-prices[0];
//
//        for(int i=1;i<n;i++){
//            temp=q;
//            q=Math.max(q,p+prices[i]);
//            p=Math.max(p,q-prices[i]);
//        }
//        return Math.max(q,p);
//    }

        public int maxProfit(int[] prices) {
            int n=prices.length;
            // 设置两个数组 思想与打家劫舍和求子序列的最大积类似 虽然可以用一个二维数组来做 但是为了保持思想与其类似 这里用两个数组来做
            int[] own=new int[n];
            int[] Nown=new int[n];
            own[0]=-prices[0];
            Nown[0]=0;
            for(int i=1;i<n;i++){
                own[i]=Math.max(own[i-1],Nown[i-1]-prices[i]);
                Nown[i]=Math.max(Nown[i-1],own[i-1]+prices[i]);
            }
            return Nown[n-1];
        }
}