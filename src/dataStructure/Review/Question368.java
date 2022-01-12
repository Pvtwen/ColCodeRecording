package dataStructure.Review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/12/2 9:57
 */
public class Question368 {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int length = nums.length;
        ArrayList<Integer>[] dp=new ArrayList[length];
        for(int i=0;i<length;i++){
            dp[i]=new ArrayList<>();
        }
        Arrays.sort(nums);
        for(int i=0;i<length;i++){
            dp[i].add(i);
        }
        for(int i=1;i<length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0){
                    if(dp[i].size()<dp[j].size()+1){
                        ArrayList<Integer> copy=new ArrayList<Integer>(dp[j]);
                        copy.add(i);
                        dp[i]=copy;
                    }
                }
            }
        }
        int maxSize=1,maxIdx=0;
        for(int i=1;i<length;i++){
            int size = dp[i].size();
            if(size>maxSize){
                maxIdx=i;
                maxSize=size;
            }
        }
        List<Integer> res=new ArrayList<>();
        for (Integer integer : dp[maxIdx]) {
            res.add(nums[integer]);
        }
        return res;
    }
}
