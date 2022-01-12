package dataStructure.Leetcode.dp.Review;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/12/6 10:01
 */
public class Question279 {
    // 完全背包==>递推
//    public int numSquares(int n) {
//        int count=0;
//        while(count*count<=n){
//            count++;
//        }
//        int[][] dp = new int[count + 1][n+1];
//        for(int i=1;i<=n;i++){
//            dp[1][i]=i;
//        }
//        int ans=n;
//        for(int i=2;i<=count;i++){
//            for(int j=1;j<=n;j++){
//                if(i*i<=j) dp[i][j]=Math.min(dp[i-1][j],dp[i][j-i*i]+1);
//                else dp[i][j]=dp[i-1][j];
//            }
//            ans=Math.min(ans,dp[i][n]);
//        }
//        return ans;
//    }
//    public int numSquares(int n) {
//        int[] dp=new int[n+1];
//        for(int i=1;i<=n;i++){
//            dp[i]=i;
//        }
//        for(int i=2;i*i<=n;i++){
//            for(int j=i*i;j<=n;j++){
//                dp[j]=Math.min(dp[j],dp[j-i*i]+1);
//            }
//        }
//        return dp[n];
//    }

    // 记忆化递归
//    HashMap<Integer,Integer> map=new HashMap<>();
//    public int numSquares(int n) {
//        return dfs(n);
//    }
//    public int dfs(int n){
//        if(n==0) return 0;
//        if(map.containsKey(n)) return map.get(n);
//        int ans=Integer.MAX_VALUE;
//        for (int i = 1; i * i <= n; i++) {
//            ans=Math.min(ans,dfs(n-i*i)+1);
//        }
//        map.put(n,ans);
//        return ans;
//    }

    // BFS 遇到终点就返回
    public int numSquares(int n) {
        Deque<int[]> queue=new ArrayDeque<>();
        Set<Integer> set=new HashSet<>();
        set.add(n);
        queue.offer(new int[]{n,0});
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int value = poll[0];
            int step = poll[1];
            for(int i=1;i*i<=value;i++){
                if(value-i*i==0) return step+1;
                if(set.contains(value-i*i)) continue;
                queue.offer(new int[]{value-i*i,step+1});
                set.add(value-i*i);
            }
        }
        return -1;
    }
}
