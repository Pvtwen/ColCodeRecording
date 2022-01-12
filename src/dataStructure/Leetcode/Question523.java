package dataStructure.Leetcode;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/9/21 15:33
 */
public class Question523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum=0,n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int prefix=(sum%k+k)%k;
            if(map.containsKey(prefix)){
                if(i+1-map.get(prefix)>1) return true;
                continue;
            }
            map.put(prefix,i+1);
        }
        return false;
    }
}
