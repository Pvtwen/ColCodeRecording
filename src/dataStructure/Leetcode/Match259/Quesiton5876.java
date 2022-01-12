package dataStructure.Leetcode.Match259;

/**
 * @author Yawen Cao
 * @data 2021/9/19 10:50
 */
public class Quesiton5876 {
    // 预处理 prefix-array  suffix-array 前缀数组保存当前下标之前的最大值  后缀数组保存当前下标之后的最小值
//    public int sumOfBeauties(int[] nums) {
//        int n=nums.length;
//        int[] l_max=new int[n];
//        int[] r_min=new int[n];
//        int Lmax=nums[0];
//        int Rmin=nums[n-1];
//
//        int beauty=0;
//
//        for(int i=1;i<=n-2;i++){
//            Lmax=Math.max(nums[i-1],Lmax);
//            l_max[i]=Lmax;
//        }
//
//        for(int i=n-2;i>=1;i--){
//            Rmin=Math.min(Rmin,nums[i+1]);
//            r_min[i]=Rmin;
//        }
//
//        for(int i=1;i<=n-2;i++){
//            if(nums[i]>l_max[i] && nums[i]<r_min[i]) beauty+=2;
//            else if(nums[i]>nums[i-1] && nums[i]<nums[i+1]) beauty+=1;
//        }
//        return beauty;
//    }

    class Solution {
        public int sumOfBeauties(int[] nums) {
            int tempF=0,maxF=0,minB=2,tempB=2;
            int beauty=0;
            int n=nums.length;
            for(int i=1;i<n-1;i++){
                if(nums[i-1]>nums[maxF]) maxF=i-1;

                if(minB==i){
                    minB=i+1;
                    for(int k=i+1;k<n;k++){
                        if(nums[minB]>nums[k]) minB=k;
                    }
                }else{
                    for(int k=tempB;k<n;k++){
                        if(nums[minB]>nums[k]) minB=k;
                        tempB++;
                    }
                }
                if(nums[i]>nums[maxF] && nums[i]<nums[minB]) beauty+=2;
                else if(nums[i]>nums[i-1] && nums[i]<nums[i+1]) beauty+=1;
            }
            return beauty;
        }
    }
}
