package dataStructure.Leetcode;

/**
 * @author Yawen Cao
 * @data 2021/10/27 15:10
 */
public class Question33 {
    public int search(int[] nums, int target) {
//        int num = nums[0];
//        int len=nums.length;
//        if(num>target){
//            int t=len-1;
//            while( t-1>=0 && nums[t]>nums[t-1]){
//                if(nums[t]==target) return t;
//                t--;
//            }
//            if(nums[t]==target) return t;
//        }else if(num<target){
//            int t=0;
//            while(t<len && nums[t]<nums[t+1]){
//                if(nums[t]==target) return t;
//                t++;
//            }
//            if(nums[t]==target) return t;
//        }else return 0;
//        return -1;
        int len=nums.length;
        int l=0,r=len-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>nums[0]){
                if(target>=nums[l] && target<nums[mid]) r=mid-1;
                else l=mid+1;
            }else if(nums[mid]<nums[0]){
                if(target<=nums[r] && target>nums[mid]) l=mid+1;
                else r=mid-1;
            }
        }
        return -1;
    }
}
