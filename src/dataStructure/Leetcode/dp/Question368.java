package dataStructure.Leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/20 20:24
 */
public class Question368 {
    // 四不像的动态规划 List<>[] dp
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        int length = nums.length;
        List<Integer> res=new ArrayList<>();
        List<Integer>[] dp=new ArrayList[length];
        // 先排序 dp[i]=nums[i]; 排序的作用：只要找到一个整除关系，例如a%b==0 就可以推断a可以整除b的所有整除元素
        // 2 4 8 只要8%4==0 因为4%2=0 那么8%2一定为0
        Arrays.sort(nums);
        for(int i=0;i<length;i++){
            dp[i]=new ArrayList<>();
            dp[i].add(nums[i]);
        }
        int maxLength=1;
        // 这里的递推思想借鉴了300题最长递增子序列。子循环遍历i下标之前的元素
        for(int i=1;i<length;i++){
            int maxIdx=-1;int flag=-1;int maxSubsetLength=0;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    // 只要大于最大子集长度，立即赋值
                    if(1+dp[j].size()>maxSubsetLength){
                        flag=1;
                        maxIdx=j;
                        maxSubsetLength=dp[j].size()+1;
                    }
                }
            }
            if(flag==1){
                // 更新dp[i]
                dp[i].addAll(dp[maxIdx]);
                // 同时，如果满足最大子集长度大于最大的返回结果长度 将最大长度赋值，同时将dp[i]赋值给res
                if(maxSubsetLength>maxLength){
                    maxLength=dp[maxIdx].size()+1;
                    res=dp[i];
                }
            }
        }
        return res;
    }
//    List<Integer> res=new ArrayList<>();
//    public List<Integer> largestDivisibleSubset(int[] nums) {
//        dfs(0,nums,new ArrayList<>());
//        return res;
//    }
//    public void dfs(int idx,int[] nums,List<Integer> ans){
//        if(ans.size()>res.size()) res=ans;
//        if(idx==nums.length) return;
//        List<Integer> copy=new ArrayList<>(ans);
//        if(condition(ans,nums[idx])){
//            dfs(idx+1,nums,ans);
//            copy.add(nums[idx]);
//            dfs(idx+1,nums,copy);
//        }else{
//            dfs(idx+1,nums,ans);
//        }
//    }
//    public boolean condition(List<Integer> ans,int num){
//        if(ans.size()==0) return true;
//        for (Integer an : ans) {
//            if(!(an%num==0 || num%an==0))return false;
//        }
//        return true;
//    }
}
