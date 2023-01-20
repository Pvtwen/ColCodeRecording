package dataStructure.Leetcode.Match282;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2022/2/27 11:33
 */
public class Q4 {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        // 记录一个轮胎(不管是哪一个！！)跑x圈的最小耗时
        int[] minSec=new int[18];
        Arrays.fill(minSec, (int) 1e8);
        for (int[] tire : tires) {
            long time=tire[0];
            for(int x=1,sum=0;time<=changeTime+tire[0];x++){
                sum+=time;
                minSec[x]=Math.min(minSec[x],sum);
                time*=tire[1];
            }
        }

        // dp[i]:跑前i圈最小耗时
        int[] dp=new int[numLaps+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 第一圈不用换 会多加一个changeTime 所以这里要减去一个changeTime
        dp[0]=-changeTime;
        for(int i=1;i<=numLaps;i++){
            // 经计算 一个轮胎最多连续使用17圈 否则一定会大于changeTime
            for(int j=1;j<=Math.min(17,i);j++){
                dp[i]=Math.min(dp[i],dp[i-j]+minSec[j]);
            }
            dp[i]+=changeTime;
        }
        return dp[numLaps];
    }
    // 不完全正确的写法 还没来得及纠正 dp状态定义的太复杂
//    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
//        int n = tires.length;
//        // 代表第i种轮胎在跑第j圈赛道时所用最小时间，轮胎所用的圈数
//        int[][] isChange=new int[n][numLaps+1];
//        // 第i种轮胎跑第j圈赛道所用的最小时间
//        int[][] dp=new int[n][numLaps+1];
//        for (int[] ints : isChange) {
//            Arrays.fill(ints,1);
//        }
//        for (int[] ints : dp) {
//            Arrays.fill(ints, (int) 1e8);
//        }
//        // 第一圈赛道
//        for(int i=0;i<n;i++){
//            dp[i][1]=tires[i][0];
//            isChange[i][1]=2;
//        }
//        for(int i=2;i<=numLaps;i++){
//            // 不换新
//            for(int j=0;j<n;j++){
//                int t = isChange[j][i - 1];
//                // 继续使用j轮胎
//                dp[j][i]= (int) (dp[j][i-1]+tires[j][0]*Math.pow(tires[j][1],t-1));
//                isChange[j][i]=t+1;
//                // 从第k个轮胎换成j轮胎
//                for(int k=0;k<n;k++){
//                    int i1 = (int) (dp[k][i-1]+changeTime+tires[j][0]);
//                    if(i1<dp[j][i]){
//                        isChange[j][i]=2;
//                        dp[j][i]=i1;
//                    }
//                }
//            }
//        }
//        int ret=Integer.MAX_VALUE;
//        for(int i=0;i<n;i++){
//            ret=Math.min(ret,dp[i][numLaps]);
//        }
//        return ret;
//    }
}
