package dataStructure.Leetcode.Match277;

/**
 * @author Yawen Cao
 * @data 2022/1/23 10:41
 */
public class Q2 {
    public int[] rearrangeArray(int[] nums) {
        int length = nums.length;
        int i = length / 2;
        int[] minus=new int[i];
        int[] posit=new int[i];
        int i1=0,i2=0;
        for(int j=0;j<length;j++){
            if(nums[j]<0){
                minus[i1]=nums[j];
                i1++;
            }
            if(nums[j]>0){
                posit[i2]=nums[j];
                i2++;
            }
        }
        int[] ret=new int[length];
        int idx=0;
        for(int j=0;j<length/2;j++){
            ret[idx]=posit[j];
            idx++;
            ret[idx]=minus[j];
            idx++;
        }
        return ret;
    }
}
