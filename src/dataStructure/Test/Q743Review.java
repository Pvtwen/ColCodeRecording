package dataStructure.Test;

import java.util.Arrays;
/**
 * @author Yawen Cao
 * @data 2022/1/18 9:26
 */
public class Q743Review {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph=new int[n+1][n+1];
        for (int[] ints : graph) {
            Arrays.fill(ints,-1);
        }
        for(int i=0;i< times.length;i++){
            int i1 = times[i][0];
            int i2 = times[i][1];
            int w = times[i][2];
            graph[i1][i2]=w;
        }
        int[] distance=new int[n+1];
        int[] visited=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        // init
        distance[k]=0;
        for(int i=1;i<=n;i++){
            if(graph[k][i]!=-1){
                distance[i]=graph[k][i];
            }
        }
        visited[k]=1;
        for(int i=1;i<=n-1;i++){
            // 找最小值
            int minIdx=-1;
            int minDis=Integer.MAX_VALUE;
            for(int j=1;j<=n;j++){
                if(visited[j]==1 || distance[j]==Integer.MAX_VALUE) continue;
                if(distance[j]<minDis){
                    minDis=distance[j];
                    minIdx=j;
                }
            }
            if(minIdx==-1) return -1;
            visited[minIdx]=1;
            // 找与minIdx连接的点
            for(int j=1;j<=n;j++){
                if(visited[j]==1 || graph[minIdx][j]==-1) continue;
                int s = minDis + graph[minIdx][j];
                if(s<distance[j])distance[j]=s;
            }
        }
        int m=0;
        for(int i=1;i<=n;i++){
            if(distance[i]>m){
                m=distance[i];
            }
        }
        return m==Integer.MAX_VALUE?-1:m;
    }
//    public int networkDelayTime(int[][] times, int n, int k) {
//        int[][] graph=new int[n+1][n+1];
//        for (int[] ints : graph) {
//            Arrays.fill(ints,-1);
//        }
//        for(int i=0;i< times.length;i++){
//            int i1 = times[i][0];
//            int i2 = times[i][1];
//            int w = times[i][2];
//            graph[i1][i2]=w;
//        }
//        int[] distance=new int[n+1];
//        int[] visited=new int[n+1];
//        Arrays.fill(distance,Integer.MAX_VALUE);
//        distance[k]=0;
//        // [0]:node [1]:distance
//        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[1]-o2[1];
//            }
//        });
//        queue.offer(new int[]{k,0});
//        while(!queue.isEmpty()){
//            int[] node = queue.poll();
//            int i = node[0];
//            if(visited[i]==1) continue;
//            visited[i]=1;
//            for(int j=1;j<=n;j++){
//                if(visited[j]==1 || graph[i][j]==-1) continue;
//                int nDis = node[1] + graph[i][j];
//                if(nDis<distance[j]) {
//                    distance[j]=nDis;
//                    queue.offer(new int[]{j,distance[j]});
//                }
//            }
//        }
//        int m=0;
//        for(int i=1;i<=n;i++){
//            m=Math.max(m,distance[i]);
//        }
//        return m==Integer.MAX_VALUE?-1:m;
//    }
}
