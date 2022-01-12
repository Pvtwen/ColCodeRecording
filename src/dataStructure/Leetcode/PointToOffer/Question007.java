package dataStructure.Leetcode.PointToOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/10/9 15:13
 */
public class Question007 {
    public static List<List<Integer>> threeSum(int[] nums) {
        // 反例  [-1,0,1,2,-1,-4,-1,-1,-2]   2跳过
        int len=nums.length;
        List<List<Integer>> res=new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0;i<len;i++){
            if(nums[i]>0) return res;

            int j=i+1,k=len-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    res.add(list);
                    while(j<k && nums[j]==nums[j+1])
                        j++;
                    while(j<k && nums[k]==nums[k-1])
                        k--;
                    j++;
                    k--;
                }else if(sum>0) k--;
                else j++;

            }
            while(i+1<len && nums[i]==nums[i+1])
                i++;
        }
        return res;
    }
}
