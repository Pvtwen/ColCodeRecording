package dataStructure.Leetcode.dp;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/12/1 16:26
 */
public class Question396 {
    public int maxRotateFunction(int[] nums) {
        int length = nums.length;
        int sum=0;
        for(int i=0;i<length;i++){
            sum+=nums[i];
        }
        int val=0;
        for(int i=0;i<length;i++){
            val+=nums[i]*i;
        }
        int max=val;
        for(int i=length-1;i>0;i--){
            val+=sum;
            val-=(length*nums[i]);
            if(val>max) max=val;
        }
        return max;
    }
//    public int maxRotateFunction(int[] nums) {
//        int length = nums.length;
//        int max=Integer.MIN_VALUE;
//        for(int i=0;i<length;i++){
//            int t=0,sum=0;
//            for(int j=(length-i)%length;t<length;t++,j=(j+1)%length){
//                sum+=nums[j]*t;
//            }
//            if(sum>max) max=sum;
//        }
//        return max;
//    }
}
