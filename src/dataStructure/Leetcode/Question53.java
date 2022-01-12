package dataStructure.Leetcode;

/**
 * @author 86153
 * @data 2021/8/3 22:40
 * 最大子序和--线段树
 */
public class Question53 {
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int maxSubArray=nums[0];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            sum = Math.max(sum, 0);
            sum+=nums[i];
            maxSubArray = Math.max(maxSubArray, sum);
        }
        return maxSubArray;
    }
}
