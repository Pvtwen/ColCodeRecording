package dataStructure.Leetcode.dp;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2022/1/1 9:56
 */
public class Question673 {
    public int findNumberOfLIS(int[] nums) {
        int length = nums.length;
        if(length==1) return 1;
        HashMap<Integer,Integer> map=new HashMap<>();
        int[][] dp=new int[length][length];
        for(int i=0;i<length;i++){
            dp[i][1]=1;
            map.put(i,1);
        }
        int maxLen=1;
        for(int i=1;i<length;i++){
            // 存放最大长度
            Integer len = map.get(i);
            for(int j=i-1;j>=0;j--){
                Integer len1 = map.get(j);
                if(nums[i]>nums[j]){
                    if(len1+1>=len){
                        len=len1+1;
                        dp[i][len]+=dp[j][len1];
                    }
                }
            }
            if(len>maxLen) maxLen=len;
            map.put(i,len);
        }
        int ret=0;
        for(int i=0;i<length;i++){
            ret+=dp[i][maxLen];
        }
        return ret;
    }
}
