package dataStructure.Leetcode.easy;

import java.util.Arrays;

/**
 * @author 86153
 * @data 2021/7/31 21:32
 */
public class Question35 {
//    public int searchInsert(int[] nums, int target) {
//        int i;
//        for(i=0;i<nums.length;i++){
//            if(target<=nums[i]){
//                return i;
//            }
//        }
//        return i;
//    }

    // 二分查找
//    public int searchInsert(int[] nums,int target){
//        return binarySearch(nums,target,0,nums.length-1);
//    }
//
//    public int binarySearch(int[] nums,int target,int i,int j){
//        if(i==j){
//            if(target>nums[i]) return i+1;
//            else return i==0?0:i;
//        }
//        int mid=(i+j)/2;
//        if(nums[mid]<target) return binarySearch(nums,target,mid+1,j);
//        else if(nums[mid]>target) return binarySearch(nums,target, i,mid);
//        else return mid;
//    }

    public static int searchInsert(int[] nums,int target){
        int l=0,r=nums.length-1,mid;
        while(l<=r){
            mid=(l+r)>>1;
            if(nums[mid]<target) l=mid+1;
            else r=mid-1;
        }
        return l;
    }
}
