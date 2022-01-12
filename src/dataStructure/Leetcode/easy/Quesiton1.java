package dataStructure.Leetcode.easy;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/9/20 15:34
 */
public class Quesiton1 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff=nums[i]-target;
            if(map.containsKey(diff)) return new int[]{map.get(diff),i};
            map.put(-nums[i],i);
        }
        return null;
    }
}
