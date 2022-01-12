package dataStructure.Leetcode.Match;

import java.util.Arrays;

/**
 * @author 86153
 * @data 2021/8/29 10:33
 */
public class Question5854 {
    public int minimumDifference(int[] nums, int k) {
        if(nums.length==0) return 0;
        Arrays.sort(nums);
        int min=Integer.MAX_VALUE;
        for(int i=0;i+k-1<nums.length;i++){
            min=Math.min(min,nums[i+k-1]-nums[i]);
        }
        return min;
    }
}
