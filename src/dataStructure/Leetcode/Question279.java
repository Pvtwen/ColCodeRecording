package dataStructure.Leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @author Yawen Cao
 * @data 2021/10/23 16:10
 */
public class Question279 {
    public int numSquares(int n) {
//        Set<Integer> set=new HashSet<>();
//        Queue<Integer> queue=new ArrayDeque<>();
//
//        int level=0;
//        queue.offer(0);
//
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            level++;
//            for(int i=0;i<size;i++){
//                Integer poll = queue.poll();
//                int sum=poll;
//                for(int j=1;sum<n;j++){
//                    sum=poll+j*j;
//                    if(sum==n) return level;
//                    if(sum<n && !set.contains(sum)){
//                        queue.offer(sum);
//                        set.add(sum);
//                    }
//                }
//            }
//        }
//        return -1;
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i]=i;
            for(int j=1;i-j*j>=0;j++){
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
