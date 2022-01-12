package dataStructure.Leetcode.Back;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/1/7 9:49
 */
public class Question46 {
    int[] visited;
    List<List<Integer>> ret=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        visited=new int[length];
        dfs(nums,new ArrayList<>(),0);
        return ret;
    }
    public void dfs(int[] nums,List<Integer> list,int cur){
        if(cur==nums.length){
            ret.add(list);
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]==0){
                List<Integer> copy=new ArrayList<>(list);
                copy.add(nums[i]);
                visited[i]=1;
                dfs(nums,copy,cur+1);
                visited[i]=0;
            }
        }
    }
}
