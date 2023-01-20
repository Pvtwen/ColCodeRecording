package dataStructure.Leetcode.Match277;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Yawen Cao
 * @data 2022/1/23 10:32
 */
public class Q1 {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int num=0;
        int min=nums[0];
        int max=nums[nums.length-1];
        for(int i=1;i+1<nums.length;i++){
            if(nums[i]>min && nums[i]<max) {
                num++;
            }
        }
        return num;
    }
}
