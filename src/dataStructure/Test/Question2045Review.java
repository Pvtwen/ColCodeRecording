package dataStructure.Test;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/11/20 10:30
 */
public class Question2045Review {
    // 边权为1 用一个统一的变量distance来记录已经走过的距离  一次访问一批set哈希表
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        ArrayList<Integer>[] neigh=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            neigh[i]=new ArrayList<>();
        }
        int length = edges.length;
        for(int i=0;i<length;i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            neigh[node1].add(node2);
            neigh[node2].add(node1);
        }

        // 错误写法 出现环就会造成步数增加的情况  map节点不唯一
//        Deque<Integer> queue=new ArrayDeque<>();
//        HashMap<Integer,Integer> map=new HashMap<>();
//        queue.offer(1);
//        map.put(1,0);
//        // step用于记录上一次到达终点的步数
//        int flag=0;int step=0;
//        int[] visited=new int[n+1];
//        while(!queue.isEmpty()){
//            Integer node = queue.poll();
//            Integer distance = map.get(node);
//            distance++;
//            for (Integer neighbour : neigh[node]) {
//                if(neighbour==n && distance>step){
//                    flag++;
//                    step=distance;
//                }
//                if(flag==2) return compute(step,time,change);
//                if(visited[neighbour]<2){
//                    queue.offer(neighbour);
//                    map.put(neighbour,distance);
//                    visited[neighbour]++;
//                }
//            }
//        }
//        return 1;

        Deque<Set<Integer>> queue=new ArrayDeque<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        queue.offer(set);
        int distance=0;
        int step=0;
        int flag=0;
        int[] visited=new int[n+1];
        while(!queue.isEmpty()){
            Set<Integer> iterSet = queue.poll();
            HashSet<Integer> childSet = new HashSet<>();
            distance++;
            for (Integer node : iterSet) {
                for (Integer neighbour : neigh[node]) {
                   if(neighbour==n && distance>step){
                       flag++;
                       step=distance;
                   }
                   if(flag==2) return compute(step,time,change);
                   if(visited[neighbour]<2) childSet.add(neighbour);
                }
            }
            queue.offer(childSet);
            for (Integer integer : childSet) {
                visited[integer]++;
            }
        }
        return 1;
    }
    public int compute(int step,int time,int change){
        int totalTime=0;
        for(int i=1;i<=step;i++){
            //红灯
            if((totalTime/change)%2==1){
                totalTime=(totalTime/change+1)*change;
            }
            totalTime+=time;
        }
        return totalTime;
    }
}
