package dataStructure.Leetcode.Match269;

/**
 * @author Yawen Cao
 * @data 2021/11/28 10:39
 */
public class Question5939 {
    public int[] getAverages(int[] nums, int k) {
        int length = nums.length;
        int[] res=new int[length];
        long[] prefixSum=new long[length+1];
        long sum=0;
        for(int i=1;i<length+1;i++){
            sum+=nums[i-1];
            prefixSum[i]=sum;
        }
        for(int i=0;i<k && i<length;i++){
            res[i]=-1;
        }
        for(int i=length-1;i>=length-k && i>=0;i--){
            res[i]=-1;
        }
        for(int i=k;i<length-k;i++){
            int aver = (int) ((prefixSum[i + k + 1] - prefixSum[i - k]) / (2 * k + 1));
            res[i]=aver;
        }
        return res;
    }
}
