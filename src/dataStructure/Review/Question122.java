package dataStructure.Review;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yawen Cao
 * @data 2021/12/2 10:33
 */
public class Question122 {
//    public int maxProfit(int[] prices) {
//        int length = prices.length;
//        int[][] dp=new int[length][2]; // 0:不持股  1:持股
//        dp[0][0]=0;
//        dp[0][1]=-prices[0];
//        for(int i=1;i<length;i++){
//            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
//            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
//        }
//        return Math.max(dp[length-1][0],dp[length-1][1]);
//    }
    public static int maxProfit(int[] prices) {
        int length = prices.length;
        Deque<Integer> queue=new ArrayDeque<>();
        int i=0,base=0,profit=0;
        while(i<length){
            if(!queue.isEmpty() && prices[queue.getLast()]<prices[i]){
                base=prices[i]-prices[queue.getFirst()];
                queue.offer(i);
                i++;
                continue;
            }else if(!queue.isEmpty() && (prices[i]<=prices[queue.getFirst()] || (prices[queue.getFirst()]<prices[i] && prices[queue.getLast()]>prices[i]))){
                profit+=base;
                base=0;
                queue.clear();
                queue.offer(i);
                i++;
                continue;
            }
            queue.offer(i);
            i++;
        }
        return profit;
    }
}
