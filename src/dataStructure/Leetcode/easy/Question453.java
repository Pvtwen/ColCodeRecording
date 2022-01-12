package dataStructure.Leetcode.easy;

/**
 * @author Yawen Cao
 * @data 2021/10/20 10:36
 */
public class Question453 {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        int length=nums.length;

        for(int i=0;i<length;i++){
            if(nums[i]<min) min=nums[i];
        }

        int res=0;
        for(int i=0;i<length;i++){
            res+=nums[i]-min;
        }

        return res;
    }
}
