package dataStructure.Leetcode;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/12/15 10:01
 */
public class Question851 {
    // 不通过hashset作为记忆化递归的过度，直接使用返回数组的标记-1作为记忆化递归的判断
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int length = richer.length;
        int n = quiet.length;
        int[] ans=new int[n];
        ArrayList<Integer>[] list=new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i]=new ArrayList<>();
        }
        // 指向有钱的人
        for(int i=0;i<length;i++){
            int p1 = richer[i][0];
            int p2 = richer[i][1];
            list[p2].add(p1);
        }
        for(int i=0;i<n;i++){
            ans[i]=-1;
        }
        for(int i=0;i<n;i++){
            dfs(i, list, quiet, ans);
        }
        return ans;
    }

    public int dfs(int person, ArrayList<Integer>[] list, int[] quiet, int[] ans) {
        if(ans[person]!=-1) return ans[person];
        if (list[person].size() == 0) {
            ans[person]=person;
            return person;
        }
        ans[person]=person;
        for (Integer p : list[person]) {
            int dfs = dfs(p, list, quiet, ans);
            if(quiet[dfs]<quiet[ans[person]]){
                ans[person]=dfs;
            }
        }
        return ans[person];
    }
//    HashMap<Integer,List<Integer>> map=new HashMap<>();
//    public int[] loudAndRich(int[][] richer, int[] quiet) {
//        int length = quiet.length;
//        int[] indegrees = new int[length];
//        int n = richer.length;
//        int[] ans=new int[length];
//        for(int i=0;i<length;i++){
//            ans[i]=i;
//        }
//        for (int i = 0; i < n; i++) {
//            int poor = richer[i][1];
//            List<Integer> con = map.getOrDefault(richer[i][0], new ArrayList<>());
//            con.add(poor);
//            map.put(richer[i][0],con);
//            indegrees[poor]++;
//        }
//        Deque<Integer> queue=new ArrayDeque<>();
//        for(int i=0;i<length;i++){
//            if(indegrees[i]==0) queue.offer(i);
//        }
//        while(!queue.isEmpty()){
//            Integer person = queue.pollFirst();
//            if(map.containsKey(person)){
//                List<Integer> list = map.get(person);
//                for (Integer p : list) {
//                    if(quiet[ans[p]]>quiet[ans[person]]){
//                        ans[p]=ans[person];
//                    }
//                    indegrees[p]--;
//                    if(indegrees[p]==0) queue.offer(p);
//                }
//            }
//        }
//        return ans;
//    }

//    HashMap<Integer,HashSet<Integer>> map=new HashMap<>();
//    public int[] loudAndRich(int[][] richer, int[] quiet) {
//        int length = richer.length;
//        int n = quiet.length;
//        ArrayList<Integer>[] list=new ArrayList[n];
//        for(int i=0;i<n;i++){
//            list[i]=new ArrayList<>();
//        }
//        for(int i=0;i<length;i++){
//            int p1 = richer[i][0];
//            int p2 = richer[i][1];
//            list[p2].add(p1);
//        }
//        // list  富有图
//        int[] answer=new int[n];
//        for (int i = 0; i < n; i++) {
//            HashSet<Integer> set;
//            if (map.containsKey(i)) {
//                set=map.get(i);
//            }
//            else set = dfs(i, list);
//            int mostQuiet = findMostQuiet(quiet, set);
//            answer[i] = mostQuiet;
//        }
//        return answer;
//    }
//    // 记忆化递归
//    public HashSet<Integer> dfs(int person,ArrayList<Integer>[] lists){
//        if(map.containsKey(person)){
//            return map.get(person);
//        }
//        HashSet<Integer> set=new HashSet<>();
//        if(lists[person].size()==0){
//            set.add(person);
//            map.put(person,set);
//            return set;
//        }
//        for (Integer rich : lists[person]) {
//            HashSet<Integer> dfs = dfs(rich , lists);
//            set.addAll(dfs);
//        }
//        set.add(person);
//        map.put(person,set);
//        return set;
//    }
//
//    // 在list中找最安静的人
//    public int findMostQuiet(int[] quiet, HashSet<Integer> set) {
//        int min=-1;
//        for (Integer integer : set) {
//            if(min==-1){
//                min=integer;
//            }else{
//                if(quiet[min]>quiet[integer])  min=integer;
//            }
//        }
//        return min;
//    }

    // 非记忆化递归 遍历递归比p富有的人
//    public void dfs(int p, List<Integer> person, ArrayList<Integer>[] list,HashSet<Integer> set) {
//        if(list==null) return;
//        for (Integer poor : list[p]) {
//            if(!set.contains(poor)){
//                person.add(poor);
//                set.add(poor);
//                dfs(poor, person, list,set);
//            }
//        }
//    }
}
