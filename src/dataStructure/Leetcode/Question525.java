package dataStructure.Leetcode;

import java.util.HashMap;

/**
 * @author Yawen Cao
 * @data 2021/9/22 18:51
 *
 */
public class Question525 {
//    public int findMaxLength(int[] nums) {
//        int n=nums.length;
//        HashMap<Integer,Integer> map=new HashMap<>();
//        int sum=0;
//        int maxLen=Integer.MIN_VALUE;
//        for(int i=0;i<n;i++){
//            if(nums[i]==0) nums[i]=-1;
//            else nums[i]=1;
//        }
//        map.put(0,0);
//        for(int i=0;i<n;i++){
//            sum+=nums[i];
//            if(map.containsKey(sum)) maxLen=Math.max(maxLen,i+1-map.get(sum));
//            else map.put(sum,i+1);
//        }
//        return maxLen==Integer.MIN_VALUE?0:maxLen;
//    }

    // 变式 求1的个数比0的个数多几个的问题
    // 变式2 求1的个数比0的个数多两倍的子数组的个数 目前只能想到用暴力法
    public int findMaxLength(int[] nums){
        int n=nums.length;
        int[] prefixSum=new int[n+1];
        int sum=0;
        int res=0;

                for(int i=0;i<n;i++){
            if(nums[i]==0) nums[i]=-1;
            else nums[i]=1;
        }

        for(int i=1;i<n+1;i++){
            sum+=nums[i-1];
            prefixSum[i]=sum;
        }

        for(int i=0;i<n+1;i++){
            for(int j=i+2;j<n+1;j++){
                int bitCount=Integer.bitCount(prefixSum[j]-prefixSum[i]);
                if(bitCount==1) res++;
            }
        }
        return res;
    }
}
