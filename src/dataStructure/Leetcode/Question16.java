package dataStructure.Leetcode;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/11/16 15:55
 */
public class Question16 {
    public int threeSumClosest(int[] nums, int target) {
        int length = nums.length;
        int res=-1,minValue=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<length;i++){
            int j=i+1,k=length-1;
            while(j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if(sum>target){
                    if(sum-target<minValue){
                        minValue=sum-target;
                        k--;
                        res=sum;
                    }
                }
                else if(sum<target){
                    if(target-sum<minValue){
                        minValue=target-sum;
                        j++;
                        res=sum;
                    }
                }
                else return sum;
            }
        }
        return res;
    }
    //    public int threeSumClosest(int[] nums, int target) {
//        int length = nums.length;
//        int res=-1,minValue=Integer.MAX_VALUE;
//        for(int i=0;i<length;i++){
//            for(int j=i+1;j<length;j++){
//                for(int k=j+1;k<length;k++){
//                    int sum=nums[i]+nums[j]+nums[k];
//                    int abs = Math.abs(sum - target);
//                    if(abs<minValue) {
//                        minValue=abs;
//                        res=sum;
//                    }
//                }
//            }
//        }
//        return res;
//    }
}
