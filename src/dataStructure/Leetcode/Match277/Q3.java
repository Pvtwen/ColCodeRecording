package dataStructure.Leetcode.Match277;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/1/23 10:45
 */
public class Q3 {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer,Integer> set=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            set.put(nums[i],set.getOrDefault(nums[i],0)+1);
        }
        List<Integer> ll=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int i1 = nums[i] + 1;
            int i2 = nums[i] - 1;
            if(!set.containsKey(i1) && !set.containsKey(i2) && set.get(nums[i])==1){
                ll.add(nums[i]);
            }
        }
        return ll;
    }
}
