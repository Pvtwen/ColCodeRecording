package dataStructure.Leetcode.Match269;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/28 10:34
 */
public class Question5938 {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(target==nums[i]) res.add(i);
        }
        return res;
    }
}
