package dataStructure.Leetcode.dp1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yawen Cao
 * @data 2022/2/8 23:03
 */
public class Q2140 {
    // topo sort ME
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[][] G= new long[n][n];
        long[] indegrees= new long[n];
        for(int i=0;i<n;i++){
            for(int j=questions[i][1]+1+i;j<n;j++){
                G[i][j]=1;
                indegrees[j]++;
            }
        }
        Deque<long[]> queue=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(indegrees[i]==0) queue.offer(new long[]{i,questions[i][0]});
        }
        long[] maxPoint= new long[n];
        for(int i=0;i<n;i++){
            maxPoint[i]=questions[i][0];
        }
        long max=0;
        while(!queue.isEmpty()){
            long[] poll = queue.poll();
            int idx = (int) poll[0];
            long point = poll[1];
            for(int i=0;i<n;i++){
                if(G[idx][i]==1){
                    indegrees[i]--;
                    maxPoint[i]=Math.max(maxPoint[i],point+questions[i][0]);
                    if(indegrees[i]==0){
                        queue.offer(new long[]{i,maxPoint[i]});
                    }
                }
            }
            max=Math.max(max,point);
        }
        return max;
    }
//    public long mostPoints(int[][] questions) {
//        int n = questions.length;
//        long[][] dp=new long[n+1][2];
//        for(int i=0;i<n;i++){
//            int pass = questions[i][1];
//            // not do
//            dp[i+1][0]=Math.max(dp[i][0],dp[i+1][0]);
//            dp[i+1][1]=Math.max(dp[i][0],dp[i+1][1]);
//            // do
//            int min = Math.min(n, i + pass + 1);
//            dp[min][0]=Math.max(dp[min][0],dp[i][1]+questions[i][0]);
//            dp[min][1]=Math.max(dp[min][1],dp[i][1]+questions[i][0]);
//        }
//        return Math.max(dp[n][0],dp[n][1]);
//    }
//    public long mostPoints(int[][] questions) {
//        int n = questions.length;
//        // [0,i) 最大分数
//        long[] dp=new long[n+1];
//        for(int i=0;i<n;i++){
//            int pass = questions[i][1];
//            // 不做i
//            dp[i+1]=Math.max(dp[i+1],dp[i]);
//            int min = Math.min(n, i + pass + i);
//            dp[min]=Math.max(dp[min],dp[i]+questions[i][0]);
//        }
//        return dp[n];
//    }
//    public long mostPoints(int[][] questions) {
//        int n = questions.length;
//        long[][] dp= new long[n][2];
//        for(int i=0;i<n;i++){
//            dp[i][1]=questions[i][0];
//        }
//        for(int i=n-1;i>=0;i--){
//            int pass = questions[i][1];
//            if(i+pass+1<n){
//                dp[i][1]=Math.max(dp[i][1],Math.max(questions[i][0]+dp[i+pass+1][1],questions[i][0]+dp[i+pass+1][0]));
//            }
//            if(i<n-1){
//                dp[i][0]=Math.max(dp[i][0],Math.max(dp[i][0]+dp[i+1][1],dp[i][0]+dp[i+1][0]));
//            }
//        }
//        return Math.max(dp[0][0],dp[0][1]);
//    }
}
