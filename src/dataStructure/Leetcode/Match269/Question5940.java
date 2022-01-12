package dataStructure.Leetcode.Match269;

/**
 * @author Yawen Cao
 * @data 2021/11/28 10:53
 */
public class Question5940 {
    public int minimumDeletions(int[] nums) {
        int length = nums.length;
        if(length==1) return 1;
        int minIdx=0,maxIdx=0;
        for(int i=1;i<length;i++){
            if(nums[minIdx]>nums[i]) minIdx=i;
            if(nums[maxIdx]<nums[i]) maxIdx=i;
        }

        int res=0;
        // 全从左边删除
        int ans1=Math.max(minIdx,maxIdx)+1;
        // 全从右边删除
        int ans2=length-Math.min(minIdx,maxIdx);
        // 两边删除
        int ans3=Math.min(minIdx,maxIdx)+1+length-Math.max(minIdx,maxIdx);
        res=Math.min(ans1,Math.min(ans2,ans3));
        return res;
    }
}
