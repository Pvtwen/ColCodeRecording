package dataStructure.Leetcode.Match269;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/11/28 11:32
 */
public class Question5941 {
    int[] parent;
    public int find(int x){
        if(parent[x]!=x) parent[x]=find(parent[x]);
        return parent[x];
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        parent=new int[n];
        Map<Integer,List<int[]>> map=new TreeMap<>();
        int length = meetings.length;
        for (int[] l : meetings) {
            int time = l[2];
            List<int[]> list = map.getOrDefault(time, new ArrayList<>());
            list.add(l);
            map.put(time,list);
        }
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        parent[firstPerson] = 0;

        for (Integer time : map.keySet()) {
            List<int[]> meeting = map.get(time);
            for (int[] l : meeting) {
                int p1 = l[0];
                int p2 = l[1];
                if(parent[find(p1)]==0 || parent[find(p2)]==0) {
                    parent[find(p1)]=0;parent[find(p2)]=0;
                }
                // 不管任何一方的祖节点是不是0 都合并
                parent[find(p1)]=parent[find(p2)];
            }
            for (int[] l : meeting) {
                int p1 = l[0];
                int p2 = l[1];
                if(parent[find(p1)]==0 || parent[find(p2)]==0) {
                    parent[find(p1)]=0;parent[find(p2)]=0;
                }
                else{
                    parent[p1]=p1;
                    parent[p2]=p2;
                }
            }
        }
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(parent[i]==0) res.add(i);
        }
        return res;
    }
//    List<Integer> res=new ArrayList<>();
//    Set<Integer> set=new HashSet<>();
//    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
//        int length = meetings.length;
//        ArrayList<Integer>[] list=new ArrayList[n];
//        for(int i=0;i<n;i++){
//            list[i]=new ArrayList<>();
//        }
//        for(int i=0;i<length;i++){
//            int p1 = meetings[i][0];
//            int p2 = meetings[i][1];
//            list[p1].add(p2);
//            list[p2].add(p1);
//        }
//        Deque<int[]> queue=new ArrayDeque<>();
//        queue.offer(new int[]{0,0});
//        queue.offer(new int[]{firstPerson,0});
//        set.add(0);set.add(firstPerson);
//        res.add(0);res.add(firstPerson);
//        while(!queue.isEmpty()){
//            int[] poll = queue.poll();
//            int person = poll[0];
//            int time = poll[1];
//            for (Integer neigh : list[person]) {
//                if(!set.contains(neigh))                findMeeting(person,neigh,time,meetings,queue);
//            }
//        }
//        return res;
//    }
//    public void findMeeting(int p1,int p2,int time,int[][] meetings,Deque<int[]> queue){
//        int length = meetings.length;
//        for(int i=0;i<length;i++){
//            int i1 = meetings[i][0];
//            int i2 = meetings[i][1];
//            if((i1==p1 && i2==p2)||(i1==p2&&i2==p1)) {
//                int t = meetings[i][2];
//                if(time<=t) {
//                    queue.offer(new int[]{p2,t});
//                    res.add(p2);set.add(p2);
//                }
//                return;
//            }
//        }
//    }
}
