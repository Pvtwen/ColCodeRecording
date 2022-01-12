package dataStructure.Leetcode.Match260;

/**
 * @author Yawen Cao
 * @data 2021/9/26 10:33
 */
public class Question5881 {
    public int maximumDifference(int[] nums) {
        int n=nums.length;
        int sub=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[j]<=nums[i]) continue;
                sub=Math.max(sub,nums[j]-nums[i]);
            }
        }
        return sub==Integer.MIN_VALUE?-1:sub;
    }
}
