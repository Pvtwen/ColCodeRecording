package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2022/1/12 10:04
 */
public class Question334 {
    public boolean increasingTriplet(int[] nums) {
        int length = nums.length;
        int[] dp=new int[length];
        int cur=1;
        dp[0]=nums[0];
        for(int i=1;i<length;i++){
            if(nums[i]>dp[cur-1]){
                dp[cur]=nums[i];
                cur++;
            }else if(nums[i]<dp[cur-1]){
                int l=0,r=cur-1;
                while(l<=r){
                    int mid=(l+r)/2;
                    if(l==r) break;
                    else if(dp[mid]<nums[i]) l=mid+1;
                    else if(dp[mid]>=nums[i]) r=mid;
                }
                dp[l]=nums[i];
            }
        }
        return cur>=3;
    }
//    public boolean increasingTriplet(int[] nums) {
//        int length = nums.length;
//        int small=nums[0];
//        int mid=-1;
//        int idx=1;
//        while(idx<length){
//            if(nums[idx]>small) {
//                mid=nums[idx];
//                idx++;
//                break;
//            }else if(nums[idx]<small){
//                small=nums[idx];
//            }
//            idx++;
//        }
//        for(int i=idx;i<length;i++){
//            if(nums[i]<small){
//                small=nums[i];
//            }else if(nums[i]>mid) return true;
//            else if(nums[i]>small && nums[i]<mid){
//                mid=nums[i];
//            }
//        }
//        return false;
//    }

}
