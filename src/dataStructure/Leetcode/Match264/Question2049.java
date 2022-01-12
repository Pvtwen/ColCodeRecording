package dataStructure.Leetcode.Match264;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/10/25 11:45
 */
public class Question2049 {
    //超时
//    int n;
//    public int countHighestScoreNodes(int[] parents) {
//        int n=parents.length;
//        this.n=n;
//        ArrayList<Integer>[] graph=new ArrayList[n];
//        for(int i=0;i<n;i++){
//            graph[i]=new ArrayList<>();
//        }
//        for(int i=1;i<n;i++){
//            graph[parents[i]].add(i);
//            graph[i].add(parents[i]);
//        }
//        int[] res=new int[n];
//        int max=Integer.MIN_VALUE;
//        for(int i=0;i<n;i++){
//            int mul=1;
//            for (Integer node : graph[i]) {
//                mul*=dfs(i,node,graph);
//            }
//            max=Math.max(max,mul);
//            res[i]=mul;
//        }
//        int total=0;
//        for (int m : res) {
//            if(m==max) total++;
//        }
//        return total;
//    }
//    public int dfs(int from,int dest,ArrayList<Integer>[] graph){
//        int a=1;
//        for (Integer node : graph[dest]) {
//            if(node==from) continue;
//            a+=dfs(dest,node,graph);
//        }
//        return a;
//    }

    int[] parent;
    public int countHighestScoreNodes(int[] parents) {
        int n=parents.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int[] count=new int[n];
        this.parent=parents;
        for(int i=0;i<n;i++){
            List<Integer> list=new ArrayList<>(map.getOrDefault(parent[i],new ArrayList<>()));
            list.add(i);
            map.put(parent[i],list);
        }
        dfs(count,0,map);
        long score;
        long max=Integer.MIN_VALUE;
        long[] res=new long[n];

        for(int i=0;i<n;i++){
            score=1;
            if(i==0){
                for (Integer child : map.get(i)) {
                    score*=count[child]+1;
                }
                max=Math.max(score,max);
                res[i]=score;
            }else{
                int parentNum=count[0]-count[i];
                score*=parentNum;
                for (Integer child : map.get(i)) {
                    score*=count[child]+1;
                }
                max=Math.max(max,score);
                res[i]=score;
            }
        }
        int total=0;
        for (long re : res) {
            if(re==max) total++;
        }
        return total;
    }
    public void dfs(int[] count,int node,HashMap<Integer,List<Integer>> map){
        List<Integer> child = map.get(node);
        if(child.size()==0) {
            return;
        }

        for (Integer ch : child) {
            dfs(count,ch,map);
            count[node]+=count[ch]+1;
        }
    }
}
