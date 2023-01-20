package dataStructure.Leetcode.Match279;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yawen Cao
 * @data 2022/2/6 10:30
 */
public class Q1 {
    public int[] sortEvenOdd(int[] nums) {
        Integer[] even;
        Integer[] odd;
        if(nums.length%2==0){
            even=new Integer[nums.length/2];
            odd=new Integer[nums.length/2];
        }else{
            even=new Integer[nums.length/2+1];
            odd=new Integer[nums.length/2];
        }
        int idx=0,idx1=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                even[idx++]=nums[i];
            }else{
                odd[idx1++]=nums[i];
            }
        }
        Arrays.sort(even);
        Arrays.sort(odd, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        idx=0;idx1=0;
        for(int i=0;i<nums.length;i++){
            if(i%2==0){
                nums[i]=even[idx++];
            }else{
                nums[i]=odd[idx1++];
            }
        }
        return nums;
    }
}
