package dataStructure.Leetcode.Match275;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/1/9 11:17
 */
public class Question5977 {

//    public int minSwaps(int[] nums) {
//        int cnt=0;
//        for (int num : nums) {
//            if(num==1) cnt++;
//        }
//        int i=0,j=i+cnt-1;
//        // double
//        int length = nums.length;
//        nums = Arrays.copyOf(nums, 2 * nums.length);
//        for(int k=length;k<2*length;k++){
//            nums[k]=nums[k-length];
//        }
//        // sliding window
//        int num0=0;
//        for(int k=0;k<cnt;k++){
//            if(nums[k]==0) num0++;
//        }
//        int num1=cnt-num0;
//        int ret=num0;
//        while(j+1<nums.length){
//            int pre = nums[i];
//            if(pre==0){
//                num0--;
//            }else num1--;
//
//            j++;
//            int num = nums[j];
//            if(num==1) num1++;
//            else num0++;
//            ret=Math.min(ret,num0);
//            i++;
//        }
//        return ret;
//    }
}
