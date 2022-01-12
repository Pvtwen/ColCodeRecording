package dataStructure.Leetcode;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author 86153
 * @data 2021/8/26 11:17
 */
public class Question547 {
//    class UnionFind{
//        int[] parent;
//        int[] rank;
//        public UnionFind(int[][] isConnected){
//            int length=isConnected[0].length;
//            parent=new int[length];
//            rank=new int[length];
//            for(int i=0;i<length;i++){
//                parent[i]=i;
//                rank[i]=1;
//            }
//        }
//
//        public int find(int i){
//            if(parent[i]!=i) parent[i]=find(parent[i]);
//            return parent[i];
//        }
//
//        public void union(int i,int j){
//            int rootx = find(i);
//            int rooty = find(j);
//            if(rootx!=rooty){
//                if(rootx<rooty){
//                    parent[rooty]=rootx;
//                    rank[rootx]+=rank[rooty];
//                    //方便后续查找rank不是1的个数 既代表了省份的个数
//                    rank[rooty]=1;
//                }else if(rootx>rooty){
//                    parent[rootx]=rooty;
//                    rank[rooty]+=rank[rootx];
//                    rank[rootx]=1;
//                }
//            }
//        }
//    }
//    public int findCircleNum(int[][] isConnected) {
//        int count=0,flag=-1;
//        UnionFind uf=new UnionFind(isConnected);
//
//        for(int i=0;i<isConnected.length;i++){
//            for(int j=0;j<isConnected[0].length;j++){
//                if(i!=j){
//                    if(isConnected[i][j]==1){
//                        uf.union(i,j);
//                        flag=1;
//                    }
//                }
//            }
//            if(flag==-1) count++;
//            flag=-1;
//        }
//
//        for (int i : uf.rank) {
//            if(i!=1) count++;
//        }
//        return count;
//    }

//DFS
//    boolean[] visited;
//    public int findCircleNum(int[][] isConnected) {
//        int length=isConnected.length,count=0;
//        visited=new boolean[length];
//        for(int i=0;i<length;i++){
//            if(!visited[i]){
//                dfs(isConnected,i);
//                count++;
//            }
//        }
//        return count;
//    }
//    public void dfs(int[][] isConnected,int i){
//        if(!visited[i]) return;
//        visited[i]=true;
//        for(int j=0;j<isConnected.length;j++){
//            if(i!=j &&  visited[j]==false && isConnected[i][j]==1)
//                dfs(isConnected,j);
//        }
//    }

    //BFS
    Queue<Integer> queue;
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int length=isConnected.length;
        int count=0;
        queue=new LinkedList<>();
        visited=new boolean[length];

        for(int i=0;i<length;i++){
            if(!visited[i]){
                queue.offer(i);
                while(!queue.isEmpty()){
                    Integer index = queue.poll();
                    for(int j=0;j<length;j++){
                        if(isConnected[index][j]==1 && j!=index && !visited[j]){
                            visited[j]=true;
                            queue.offer(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}