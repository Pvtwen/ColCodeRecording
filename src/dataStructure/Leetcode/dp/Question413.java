package dataStructure.Leetcode.dp;

/**
 * @author Yawen Cao
 * @data 2021/12/1 17:29
 */
public class Question413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int length = nums.length;
        int[] dp=new int[length];
        int sum=0;
        for(int i=2;i<length;i++){
            dp[i]=(nums[i]-nums[i-1]==nums[i-1]-nums[i-2])?dp[i-1]+1:0;
            sum+=dp[i];
        }
        return sum;
    }
}
