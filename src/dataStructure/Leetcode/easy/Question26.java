package dataStructure.Leetcode.easy;

/**
 * @author 86153
 * @data 2021/7/29 21:22
 */
public class Question26 {
    public int removeDuplicates(int[] nums) {
        int i=0;//用i记录数组长度
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                nums[++i]=nums[j];
            }
        }
        return (i+1);
    }
}
