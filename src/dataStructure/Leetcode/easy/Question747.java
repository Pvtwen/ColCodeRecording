package dataStructure.Leetcode.easy;

/**
 * @author Yawen Cao
 * @data 2022/1/13 9:34
 */
public class Question747 {
    public int dominantIndex(int[] nums) {
        int length = nums.length;
        if(length==1) return 0;
        int max= nums[0];
        int maxIdx=0;
        for(int i=1;i<length;i++){
            if(nums[i]>max){
                max=nums[i];
                maxIdx=i;
            }
        }
        for(int i=0;i<length;i++){
            if(i==maxIdx) continue;
            if(nums[i]*2>max) return -1;
        }
        return maxIdx;
    }
}
