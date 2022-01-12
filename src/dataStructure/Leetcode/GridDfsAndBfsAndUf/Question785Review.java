package dataStructure.Leetcode.GridDfsAndBfsAndUf;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author Yawen Cao
 * @data 2021/12/7 15:28
 */
public class Question785Review {
    //DFS
    int[] visited;
    public boolean isBipartite(int[][] graph) {
        int length = graph.length;
        visited=new int[length];
        for (int i = 0; i < length; i++) {
            if (visited[i] == 0) {
                visited[i]=1;
                boolean b = dfs(graph, i);
                if(!b) return false;
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int cur) {
        for (int neigh : graph[cur]) {
            if (visited[neigh] != 0) {
                if (visited[neigh] == visited[cur]) return false;
            } else {
                visited[neigh] = -visited[cur];
                boolean b = dfs(graph, neigh);
                if(!b) return false;
            }
        }
        return true;
    }
    // BFS
//    static int[] color;
//    public static boolean isBipartite(int[][] graph) {
//        int length = graph.length;
//        color=new int[length];
//        Deque<Integer> queue=new ArrayDeque<>();
//        for(int i=0;i<length;i++){
//            if(color[i]==0){
//                queue.offer(i);
//                color[i]=1;
//                while(!queue.isEmpty()){
//                    Integer node = queue.poll();
//                    for(int neigh:graph[node]){
//                        if(color[neigh]!=0){
//                            if(color[neigh]==color[node]) return false;
//                        }else{
//                            color[neigh]=-color[node];
//                            queue.offer(neigh);
//                        }
//                    }
//                }
//            }
//        }
//        return true;
//    }
}
