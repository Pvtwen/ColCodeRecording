package dataStructure.Review;

/**
 * @author Yawen Cao
 * @data 2021/12/2 10:21
 */
public class Question152 {
    public static int maxProduct(int[] nums) {
        int length = nums.length;
        int[][] dp=new int[length][2]; //0 负数最小 1 正数最大
        for(int i=0;i<length;i++){
            dp[i][0]=dp[i][1]=nums[i];
        }
        int res;
        res=Math.max(dp[0][0],dp[0][1]);
        for(int i=1;i<length;i++){
            dp[i][0]=Math.min(dp[i][0],Math.min(nums[i]*dp[i-1][0],nums[i]*dp[i-1][1]));
            dp[i][1]=Math.max(dp[i][1],Math.max(nums[i]*dp[i-1][1],nums[i]*dp[i-1][0]));
            res=Math.max(res,Math.max(dp[i][0],dp[i][1]));
        }
        return res;
    }
}
