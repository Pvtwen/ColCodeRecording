package dataStructure.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author Yawen Cao
 * @data 2021/11/16 15:30
 */
public class Question15 {
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if(length<3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<length;i++){
            if(nums[i]>=0) return res;
            int j=i+1,k=length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);list.add(nums[j]);list.add(nums[k]);
                    res.add(list);
                    while(j<k &&nums[j]==nums[j+1]) j++;
                    while (j<k && nums[k]==nums[k-1]) k--;
                    j++;
                    k--;
                }
                else if(sum<0){
                    j++;
                }
                else k--;
            }
            while(i+1<length && nums[i]==nums[i+1]){
                i++;
            }
        }
        return res;
    }
}
