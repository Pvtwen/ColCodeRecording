package dataStructure.Leetcode;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/9/13 16:54
 */
public class Question560 {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int sum=0;
        int n=nums.length;
        int res=0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int diff=sum-k;
            if(map.containsKey(diff)) res+=map.get(diff);
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}
