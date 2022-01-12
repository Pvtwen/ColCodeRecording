package dataStructure.Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

/**
 * @author Yawen Cao
 * @data 2021/11/5 18:09
 */
public class Question365 {
//    int[][] visited;
//    int V1;
//    int V2;
//    int target;
//    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
//        V1=jug1Capacity;
//        V2=jug2Capacity;
//        target=targetCapacity;
//        visited=new int[jug1Capacity+1][jug2Capacity+1];
//        return dfs(V1,V2);
//    }
//
//    public boolean dfs(int v1,int v2){
//        if(v1<0) v1=0;
//        if(v2<0) v2=0;
//
//        if(v1>V1) v1=V1;
//        if(v2>V2) v2=V2;
//
//        if(v1==target || v2==target || (v1+v2)==target) return true;
//
//        if(visited[v1][v2]==1) return false;
//        visited[v1][v2]=1;
//
//        for(int i=1;i<=6;i++){
//            if(i==1){
//                //1 -> 2
//                if(dfs(v1-(V2-v2),v2+v1)) return true;
//            }else if(i==2){
//                // 2->1
//                if(dfs(v1+v2,v2-(V1-v1))) return true;
//            }else if(i==5){
//                // 1 full
//                if(dfs(V1,v2)) return true;
//            }else if(i==6){
//                // 2full
//                if(dfs(v1,V2)) return true;
//            }else if(i==3){
//                //1 empty
//                if(dfs(0,v2)) return true;
//            }else{
//                if(dfs(v1,0)) return true;
//            }
//        }
//        return false;
//    }

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        Deque<int[]> stack=new ArrayDeque<>();
        HashSet<Long> set=new HashSet<>();
        int[] init=new int[]{jug1Capacity,jug2Capacity};
        stack.push(init);
        set.add(hash(init));

        while(!stack.isEmpty()){
            int[] top = stack.getLast();
            if(set.contains(hash(top))){
                stack.removeLast();
                continue;
            }

            if(top[0]==targetCapacity || top[1]==targetCapacity || (top[0]+top[1])==targetCapacity) return true;
            set.add(hash(top));

            // 1 empty
            stack.offer(new int[]{0,top[1]});
            // 2 empty
            stack.offer(new int[]{top[0],0});
            // 1 full
            stack.offer(new int[]{jug1Capacity,top[1]});
            // 2 full
            stack.offer(new int[]{top[0],jug2Capacity});
            //1->2
            int min = Math.min(top[0], jug2Capacity - top[1]);
            stack.offer(new int[]{top[0]-min,top[1]+min});
            // 2->1
            int min1 = Math.min(top[1], jug1Capacity - top[0]);
            stack.offer(new int[]{top[0]+min1,top[1]-min1});
        }
        return false;
    }
    public long hash(int[] arr){
        return (long)arr[0]*1000001+arr[1];
    }
}
