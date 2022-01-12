package dataStructure.Test.LineAndDot;

/**
 * @author Yawen Cao
 * @data 2021/10/28 17:41
 */
public class NewQuestion912 {
    public int[] sortArray(int[] nums) {
        int len = nums.length;

        // 趟数
//        for (int i = 1; i <= len - 1; i++) {
//            int maxIdx = 0;
//            for (int j = 1; j < len - i + 1; j++) {
//                if (nums[j] > nums[maxIdx]) maxIdx = j;
//            }
//            swap(nums,maxIdx,len-i);
//        }

        // idx
        for(int i=0;i<len-1;i++){
            for(int j=i+1;j<len;j++){
                if(nums[j]<nums[i]) swap(nums,i,j);
            }
        }
        return nums;
    }
    public void swap(int[] nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
