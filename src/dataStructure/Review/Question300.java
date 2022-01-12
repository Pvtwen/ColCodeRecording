package dataStructure.Review;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/12/2 9:47
 */
public class Question300 {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        int[] dp=new int[length];
        Arrays.fill(dp, 1);
        int res=1;
        for(int i=1;i<length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
