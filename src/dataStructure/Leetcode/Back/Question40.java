package dataStructure.Leetcode.Back;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/1/5 15:35
 */
public class Question40 {
    HashSet<List<Integer>> set=new HashSet<>();
    boolean[] visited;
    List<List<Integer>> ret=new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates,target,0,0,new ArrayList<>());
        return ret;
    }
    public void dfs(int[] candidates,int target,int sum,int cur,List<Integer> res){
        if(sum==target){
            if(!set.contains(res)){
                set.add(res);
                ret.add(res);
            }
            return;
        }
        for(int start=cur;start<candidates.length;start++){
            if(sum+candidates[start]>target) break;
            if(start!=cur && candidates[start]==candidates[start-1]) continue;
            List<Integer> copy=new ArrayList<>(res);
            copy.add(candidates[start]);
            dfs(candidates,target,sum+candidates[start],start,copy);
        }
    }
//    List<List<Integer>> ret=new ArrayList<>();
//    HashSet<List<Integer>> set=new HashSet<>();
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        for(int i=0;i<candidates.length;i++){
//            dfs(candidates,target,0,i,new ArrayList<>());
//        }
//        return ret;
//    }
//    public void dfs(int[] candidates,int target,int sum,int cur,List<Integer> res){
//        if(sum>target) return;
//        if(sum==target){
//            if(!set.contains(res)){
//                set.add(res);
//                ret.add(res);
//            }
//            return;
//        }
//        int temp=sum+candidates[cur];
//        if(temp>target) return;
//        List<Integer> copy=new ArrayList<>(res);
//        copy.add(candidates[cur]);
//        //
//        for(int start=cur+1;start<candidates.length;start++){
//            dfs(candidates,target,temp,start,copy);
//        }
//    }
}
