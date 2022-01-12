package dataStructure.Leetcode.Back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/1/4 11:02
 */
public class Question39 {
    List<List<Integer>> ret=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0,0,new ArrayList<>());
        return ret;
    }
    public void dfs(int[] candidates,int target,int idx,int sum,List<Integer> res){
        if(sum==target){
            ret.add(res);
            return;
        }
        List<Integer> copy=new ArrayList<>(res);
        // 取本身 如果超过了target 直接回溯
        if(sum+candidates[idx]>target) return;
        copy.add(candidates[idx]);
        dfs(candidates,target,idx,sum+candidates[idx],copy);

        // 往后取
        for(int start=idx+1;start<candidates.length;start++){
            if(sum+candidates[start]>target) return;
            List<Integer> copy1=new ArrayList<>(res);
            copy1.add(candidates[start]);
            dfs(candidates,target,start,sum+candidates[start],copy1);
        }
    }

    // 求总和  不求具体方案
//    public int combinationSum(int[] candidates, int target){
//        int length = candidates.length;
//        int[][] dp=new int[length+1][target+1];
//        dp[0][0]=1;
//        for(int i=1;i<=length;i++){
//            dp[i][0]=1;
//            for(int j=1;j<=target;j++){
//                if(j>=candidates[i-1]) dp[i][j]=dp[i-1][j]+dp[i][j-candidates[i-1]];
//                else dp[i][j]=dp[i-1][j];
//            }
//        }
//        // 打表
//        for(int i=0;i<=length;i++){
//            System.out.println("i="+i);
//            for(int j=0;j<=target;j++){
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//
//        return dp[length][target];
//    }
}
