package dataStructure.Leetcode.Match283;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2022/3/6 10:44
 */
public class Q2 {
    public long minimalKSum(int[] nums, int k) {
        int n = nums.length;
        nums = Arrays.copyOf(nums, n + 1);
        nums[n]=0;
        Arrays.sort(nums);
        int idx=0;
        long ret=0;
        while(idx<n && k>0){
            // total
            if(nums[idx+1]-nums[idx]==0){
                idx++;
                continue;
            }
            int t = nums[idx+1] - nums[idx]-1;
            if(k>=t) {
                k-=t;
                ret+=((long)nums[idx]+nums[idx+1])*t/2;
            }else{
                ret+=((long)nums[idx]+1+nums[idx]+k)*k/2;
                k=0;
            }
            idx++;
        }
        // max nums[n]
        if(k>0){
            ret+=((long)nums[n]+1+nums[n]+k)*k/2;
        }
        return ret;
    }
}
