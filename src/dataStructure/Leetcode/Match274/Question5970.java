package dataStructure.Leetcode.Match274;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/1/2 11:02
 */
public class Question5970 {
    // 拓扑排序
    public int maximumInvitations(int[] favorite) {
        int length = favorite.length;
        int[] indegrees=new int[length];
        for(int i=0;i<length;i++){
            int peo = favorite[i];
            indegrees[peo]++;
        }
        Deque<Integer> queue=new ArrayDeque<>();
        for(int i=0;i<length;i++){
            if(indegrees[i]==0) queue.offer(i);
        }
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            int fav = favorite[poll];
            indegrees[fav]--;
            if(indegrees[fav]==0) queue.offer(fav);
        }
        // 最后查找入度不为0的人数
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<length;i++){
            if(indegrees[i]!=0) list.add(i);
        }
        int size = list.size();
        long maxRoll=0;

        // 哈希表用啦记录 基环的个数
        HashMap<Integer,Integer> map=new HashMap<>();
        boolean[] visited=new boolean[length];
        for(int i=0;i<size;i++){
            int j = list.get(i);
            int temp=favorite[j];
            if(visited[j]) continue;
            visited[j]=true;
            int time=1;
            while(temp!=j){
                visited[temp]=true;
                temp=favorite[temp];
                time++;
            }
            if(time>2) maxRoll=Math.max(maxRoll,time);
            // time==2
            else map.put(j,time);
        }
        //构建反图
        ArrayList<Integer>[] lists=new ArrayList[length];
        for(int i=0;i<length;i++){
            lists[i]=new ArrayList<>();
        }
        for(int i=0;i<length;i++){
            int i1 = favorite[i];
            lists[i1].add(i);
        }
        long sum=0;
        for (Integer p : map.keySet()) {
            int p1 = favorite[p];
            long dfs = dfs(p, lists, p1);
            long dfs1 = dfs(p1, lists, p);
            sum+=dfs+dfs1;
        }
        maxRoll=Math.max(maxRoll,sum);
        return (int) maxRoll;
    }
    public long dfs(int p,ArrayList<Integer>[] lists,int p1){
        if(lists[p].size()==0) return 1;
        long len=1;
        for (Integer i : lists[p]) {
            if(i==p1) continue;
            len=Math.max(len,dfs(i,lists,p1)+1);
        }
        return len;
    }
}
