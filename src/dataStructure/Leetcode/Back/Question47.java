package dataStructure.Leetcode.Back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/1/7 9:56
 */
public class Question47 {
    List<List<Integer>> ret=new ArrayList<>();
    int[] visited;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        visited=new int[nums.length];
        int[] result=new int[nums.length];
        dfs(nums,result,0);
        return ret;
    }
    public void dfs(int[] nums,int[] result,int cur){
        if(cur==nums.length){
            List<Integer> li=new ArrayList<>();
            for (int i : result) {
                li.add(i);
            }
            ret.add(li);
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(i==0 || (nums[i]!=nums[i-1])){
                int c1=0,c2=0;
                for(int j=0;j<cur;j++) if(result[j]==nums[i]) c1++;
                for(int j=0;j<nums.length;j++) if(nums[i]==nums[j]) c2++;
                if(c1<c2){
                    result[cur]=nums[i];
                    dfs(nums,result,cur+1);
                }
            }
        }
    }
    // cur:指代nums的下标
    public void dfs(int[] nums,List<Integer> list){
        if(list.size()==nums.length){
            ret.add(list);
            return;
        }
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(visited[i]==0){
                if(!set.contains(nums[i])){
                    set.add(nums[i]);
                    List<Integer> copy=new ArrayList<>(list);
                    copy.add(nums[i]);
                    visited[i]=1;
                    dfs(nums,copy);
                    visited[i]=0;
                }
            }
        }
    }
}
