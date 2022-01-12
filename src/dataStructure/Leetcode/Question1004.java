package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2021/10/3 16:35
 * 类比5873题 滑动窗口双指针
 */
public class Question1004 {
    public static int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int i=0,j=0;
        int num0=0;
        int res=Integer.MIN_VALUE;
        while(j<n){
            if(nums[j]==0) num0++;
            if(num0<=k){
                res=Math.max(res,j-i+1);
            }else{
                while(i<n && num0>k){
                    if(nums[i]==0) num0--;
                    i++;
                }
            }
            j++;
        }

        return res==Integer.MIN_VALUE?0:res;
    }
}
