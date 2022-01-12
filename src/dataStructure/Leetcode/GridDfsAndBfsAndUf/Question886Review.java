package dataStructure.Leetcode.GridDfsAndBfsAndUf;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author Yawen Cao
 * @data 2021/12/7 15:56
 */
public class Question886Review {
    static int[] visited;
    //BFS
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[] list = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i]=new ArrayList<>();
        }
        visited=new int[n+1];
        int length = dislikes.length;
        for (int i = 0; i < length; i++) {
            int p1 = dislikes[i][0];
            int p2 = dislikes[i][1];
            list[p1].add(p2);
            list[p2].add(p1);
        }
        Deque<Integer> deque=new ArrayDeque<>();
        for(int i=1;i<=n;i++){
            if(visited[i]==0){
                deque.offer(i);
                visited[i]=1;
                while(!deque.isEmpty()){
                    Integer node = deque.poll();
                    for (Integer neigh : list[node]) {
                        if(visited[neigh]!=0){
                            if(visited[neigh]==visited[node]) return false;
                        }else{
                            visited[neigh] = -visited[node];
                            deque.offer(neigh);
                        }
                    }
                }
            }
        }
        return true;
    }
    // DFS
//    public static boolean possibleBipartition(int n, int[][] dislikes) {
//        ArrayList<Integer>[] list = new ArrayList[n+1];
//        for(int i=1;i<=n;i++){
//            list[i]=new ArrayList<>();
//        }
//        visited=new int[n+1];
//        int length = dislikes.length;
//        for (int i = 0; i < length; i++) {
//            int p1 = dislikes[i][0];
//            int p2 = dislikes[i][1];
//            list[p1].add(p2);
//            list[p2].add(p1);
//        }
//        for (int i = 1; i <= n; i++) {
//            if(visited[i]==0){
//                visited[i]=1;
//                boolean dfs = dfs(list, i);
//                if (!dfs) return false;
//            }
//        }
//        return true;
//    }
//    public static boolean dfs(ArrayList<Integer>[] list,int cur){
//        for (Integer neigh : list[cur]) {
//            if(visited[neigh]!=0){
//                if(visited[cur]==visited[neigh]) return false;
//            }else{
//                visited[neigh]=-visited[cur];
//                boolean dfs = dfs(list, neigh);
//                if(!dfs) return false;
//            }
//        }
//        return true;
//    }
}
