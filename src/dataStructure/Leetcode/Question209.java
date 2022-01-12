package dataStructure.Leetcode;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2021/9/19 15:19
 */
public class Question209 {
    // 前缀和+二分查找
//    public static int minSubArrayLen(int target, int[] nums) {
//        int n=nums.length;
//        int minLength=Integer.MAX_VALUE;
//        int[] arr=new int[n+1];
//        for(int i=1;i<n+1;i++){
//            arr[i]=arr[i-1]+nums[i-1];
//        }
//
//        for(int i=1;i<n+1;i++){
//            int s=target+arr[i-1];
//            int bound = Arrays.binarySearch(arr, s);
//            if(bound<0) bound=-bound-1;
//            if(bound<=n) minLength=Math.min(minLength,bound-i+1);
//        }
//        return minLength==Integer.MAX_VALUE?0:minLength;
//    }

    // 滑动窗口
    public static int minSubArrayLen(int target, int[] nums) {
        int i,j;
        int res=Integer.MAX_VALUE;
        int sum=0;
        int n=nums.length;
        i=j=0;
        while(j<n){
            sum+=nums[j];
            while(sum>=target){
                res=Math.min(res,j-i+1);
                sum-=nums[i];
                i++;
            }
            j++;
        }
        return res==Integer.MAX_VALUE?0:res;
    }
}
