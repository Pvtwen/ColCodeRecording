package dataStructure.Leetcode.dp.Hard;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Yawen Cao
 * @data 2021/12/8 10:48
 */
public class Question689 {
    // 可以改动一下边界问题 边界选择了三叶的做法
    public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        long[] sum = new long[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        long[][] dp = new long[n +10][4];
        for (int i = n - k + 1; i >= 1; i--) {
            for (int j = 1; j <= 3; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + k][j - 1] + sum[i + k - 1] - sum[i - 1]);
            }
        }
        for(int i=n-k+1;i>=1;i--){
            for(int j=1;j<=3;j++){
                System.out.println(i+"到"+n+"的范围内,已选出的数组的个数为"+j+"时,所能取得最大和为:"+dp[i][j]);
            }
        }
        int[] ans = new int[3];
        int i = 1, j = 3, idx = 0;
        while (j > 0){
            // 如果当前dp是由dp[i+1][j]转移而来，i++ 否则
            System.out.println("i:"+i+",j:"+j);
            System.out.println("dp[i][j]:" + dp[i][j] + ",dp[i+1][j]:" +dp[i+1][j]+",dp[i+k][j-1]+sum[i+k-1]-sum[i-1]:"+(dp[i + k][j - 1] + sum[i + k - 1] - sum[i - 1]));
            if(dp[i+1][j]>dp[i+k][j-1]+sum[i+k-1]-sum[i-1]){
                i++;
            }else {
                ans[idx] = i - 1;
                i += k;
                idx++;
                j--;
            }
        }
        return ans;
    }
//    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
//        int length = nums.length;
//        int[] prefixSumArr=new int[length+1];
//        int sum=0;
//        for(int i=1;i<=length;i++){
//            sum+=nums[i-1];
//            prefixSumArr[i]=sum;
//        }
//        int[][] dp=new int[length+1][3];
//        // 逆序递推 方便回溯  类似01背包的dp写法
//        for(int i=length-k+1;i>=1;i--){
//            for(int j=1;j<4;j++){
//                dp[i][j]=Math.max(dp[i+1][j],dp[i+k][j-1]+prefixSumArr[i+k-1]-prefixSumArr[i-1]);
//            }
//        }
//        return dp[1][3];
//    }
}
