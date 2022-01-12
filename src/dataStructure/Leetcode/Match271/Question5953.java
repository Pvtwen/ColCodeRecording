package dataStructure.Leetcode.Match271;

/**
 * @author Yawen Cao
 * @data 2021/12/12 10:57
 */
public class Question5953 {
    // 严格按照dp来写
    public long subArrayRanges(int[] nums) {
        int length = nums.length;
        int[][] minDp=new int[length][length];
        int[][] maxDp=new int[length][length];
        long sum=0;
        for(int i=0;i<length;i++){
            maxDp[i][i]=nums[i];
            minDp[i][i]=nums[i];
            for(int j=i+1;j<length;j++){
                maxDp[i][j]=Math.max(maxDp[i][j-1],nums[j]);
                minDp[i][j]=Math.min(minDp[i][j-1],nums[j]);
                sum+=maxDp[i][j]-minDp[i][j];
            }
        }
        return sum;
    }
//    public long subArrayRanges(int[] nums) {
//        int length = nums.length;
//        int[][] max=new int[length][length];
//        int[][] min=new int[length][length];
//        for (int i = 0; i < length; i++) {
//            int mMax=nums[i];
//            int mMin=nums[i];
//            for (int j = i; j < length; j++) {
//                if(nums[j]>mMax){
//                    mMax=nums[j];
//                }
//                if(nums[j]<mMin){
//                    mMin=nums[j];
//                }
//                max[i][j]=mMax;
//                min[i][j]=mMin;
//            }
//        }
//        long sum=0;
//        for(int i=0;i<length;i++){
//            for(int j=i;j<length;j++){
//                sum+=max[i][j]-min[i][j];
//            }
//        }
//        return sum;
//    }
}
