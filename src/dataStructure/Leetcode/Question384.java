package dataStructure.Leetcode;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/11/22 16:04
 */
public class Question384 {
    int[] nums;
    int[] copy;
    public Question384(int[] nums) {
        int length = nums.length;
        this.nums=nums;
        copy= Arrays.copyOf(nums,length);
    }

    public int[] reset() {
        copy=Arrays.copyOf(nums,nums.length);
        return copy;
    }

    public int[] shuffle() {
        int length = nums.length;
        int temp;
        for(int i=length-1;i>=0;i--){
            int randomIndex = (int) (Math.random() * (i + 1));
            temp=copy[randomIndex];
            copy[randomIndex]=copy[i];
            copy[i]=temp;
        }
        return copy;
    }
}
