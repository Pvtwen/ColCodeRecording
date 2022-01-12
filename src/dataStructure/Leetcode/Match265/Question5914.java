package dataStructure.Leetcode.Match265;

/**
 * @author Yawen Cao
 * @data 2021/10/31 10:31
 */
public class Question5914 {
    public int smallestEqual(int[] nums) {
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(i%10==nums[i]) return i;
        }
        return -1;
    }
}
