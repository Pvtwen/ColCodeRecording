package dataStructure.Leetcode;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2022/1/13 17:04
 */
public class Question743 {
    int N=110;
    int M=6010;
    int[] e=new int[M]; //边
    int[] ne=new int[M]; //边 用于找某条边的下一个边
    int[] he=new int[N];    // 用于找某个节点的
    int[] w=new int[M]; // 边
    int  idx=1;
    void add(int x,int y,int w1){
        e[idx]=y;
        ne[idx]=he[x];
        he[x]=idx;
        w[idx]=w1;
        idx++;
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Arrays.fill(he,-1);
        for(int i=0;i<times.length;i++){
            add(times[i][0],times[i][1],times[i][2]);
        }
        int[] distance=new int[n+1];
        Arrays.fill(distance, (int) 1e8);
        int[] visited=new int[n+1];
        // 记录每个节点进入队列的次数 如果大于等于检查的极限 就返回false
        int[] cnt=new int[n+1];
        distance[k]=0;;
        Deque<Integer> queue=new ArrayDeque<>();
        queue.addLast(k);
        visited[k]=1;
        while(!queue.isEmpty()){
            Integer node = queue.pollFirst();
            // 出队列之后 标记为没有在队列
            visited[node]=0;
            for(int i=he[node];i!=-1;i=ne[i]){
                // 找到边i连接的节点j
                int j = e[i];
                if(distance[j]>distance[node]+w[i]){
                    distance[j]=Math.min(distance[j],distance[node]+w[i]);
                    if(visited[j]==1) continue;
                    queue.addLast(j);
                    visited[j]=1;
                }
            }
        }
        int m=0;
        for(int i=1;i<=n;i++){
            if(distance[i]>=1e8) return -1;
            if(distance[i]>m) m=distance[i];
        }
        return m;
}
//    public int networkDelayTime(int[][] times, int n, int k) {
//        Arrays.fill(he,-1);
//        for(int i=0;i<times.length;i++){
//            int x = times[i][0];
//            int y = times[i][1];
//            int w = times[i][2];
//            add(x,y,w);
//        }
//
//        int[] distance=new int[n+1];
//        Arrays.fill(distance, (int) 1e8);
//        distance[k]=0;
//        for(int i=1;i<=n-1;i++){
//            for(int a=1;a<=n;a++){
//                for(int h=he[a];h!=-1;h=he[h]){
//                    int b=e[h];
//                    distance[b]=Math.min(distance[b],distance[a]+w[h]);
//                }
//            }
//        }
//        int m=0;
//        for(int i=1;i<=n;i++){
//            if(distance[i]>=1e8) return -1;
//            if(distance[i]>m) m=distance[i];
//        }
//        return m;
//    }

//    class Edge{
//        int u;
//        int v;
//        int w;
//        Edge(int u,int v,int w){
//            this.u=u;
//            this.v=v;
//            this.w=w;
//        }
//    }
//    public int networkDelayTime(int[][] times, int n, int k) {
//        int len = times.length;
//        List<Edge> list=new ArrayList<>();
//        for(int i=0;i<len;i++){
//            int u = times[i][0];
//            int v = times[i][1];
//            int w = times[i][2];
//            list.add(new Edge(u,v,w));
//        }
//        int[] distance=new int[n+1];
//        Arrays.fill(distance, (int) 1e8);
//        distance[k]=0;
//        for(int i=1;i<=n-1;i++){
//            for (Edge edge : list) {
//                int u = edge.u;
//                int v = edge.v;
//                int w = edge.w;
//                if(distance[u]+w<distance[v]){
//                    distance[v]=distance[u]+w;
//                }
//            }
//        }
//        int m=0;
//        for(int  i=1;i<=n;i++){
//            if(distance[i]>=1e8) return -1;
//            if(distance[i]>m) m=distance[i];
//        }
//        return m;
//    }

//    public int networkDelayTime(int[][] times, int n, int k) {
//        int[][] A=new int[n+1][n+1];
//        for (int[] ints : A) {
//            Arrays.fill(ints, (int) 1e8);
//        }
//        for(int i=0;i< times.length;i++){
//            int i1 = times[i][0];
//            int i2 = times[i][1];
//            int w = times[i][2];
//            A[i1][i2]=w;
//        }
//
//        int[][] path=new int[n+1][n+1];
//        for (int[] ints : path) {
//            Arrays.fill(ints,-1);
//        }
//        for(int v=1;v<=n;v++){
//            for(int i=1;i<=n;i++){
//                for(int j=1;j<=n;j++){
//                    if(A[i][v]+A[v][j]<A[i][j]){
//                        path[i][j]=v;
//                        A[i][j]=A[i][v]+A[v][j];
//                    }
//                }
//            }
//        }
//        int m=0;
//        for(int i=1;i<=n;i++) {
//            if(i==k) continue;
//            else{
//                if(A[k][i]>=1e8) return -1;
//                m=Math.max(m,A[k][i]);
//            }
//        }
//        return m;
//    }
//    public int networkDelayTime(int[][] times, int n, int k) {
//        int[][] graph=new int[n+1][n+1];
//        int[] distance=new int[n+1];
//        Arrays.fill(distance,Integer.MAX_VALUE);
//        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return distance[o1[1]]-distance[o2[1]];
//            }
//        });
//        for (int[] ints : graph) {
//            Arrays.fill(ints,-1);
//        }
//        for (int[] time : times) {
//            int souce = time[0];
//            int dest = time[1];
//            int t = time[2];
//            graph[souce][dest]=t;
//        }
//        int[] visited=new int[n+1];
//        distance[k]=0;
//        queue.offer(new int[]{k,0});
//        while(!queue.isEmpty()){
//            int[] node = queue.poll();
//            int i1 = node[0];
//            int dist = node[1];
//            // 松弛
//            if(visited[i1]==1) continue;
//            visited[i1]=1;
//            for(int i=1;i<=n;i++){
//                if(visited[i]==0 && graph[i1][i]!=-1){
//                    int i2 = dist + graph[i1][i];
//                    if(i2<distance[i]){
//                        distance[i]=i2;
//                        queue.offer(new int[]{i,distance[i]});
//                    }
//                }
//            }
//        }
//        int maxTime=Integer.MIN_VALUE;
//        for(int i=1;i<=n;i++){
//            if(distance[i]==Integer.MAX_VALUE) return -1;
//            maxTime=Math.max(maxTime,distance[i]);
//        }
//        return maxTime;
//    }
//    public int networkDelayTime(int[][] times, int n, int k) {
//        int[][] graph=new int[n+1][n+1];
//        int[] distance=new int[n+1];
//        for (int[] ints : graph) {
//            Arrays.fill(ints,-1);
//        }
//        //这里必须初始化为一个很大的值 否则后面比较 minNode+distance[] 会永远比-1大
//        // 但是，graph[i]=-1 无影响 表示不可达
//        Arrays.fill(distance,Integer.MAX_VALUE);
//        distance[k]=0;
//        for (int[] time : times) {
//            int source = time[0];
//            int dest = time[1];
//            int t = time[2];
//            graph[source][dest]=t;
//        }
//        // 初始化
//        int[] visited=new int[n+1];
//        visited[k]=1;
//        int maxTime=Integer.MIN_VALUE;
//        for(int i=1;i<=n;i++){
//            if(graph[k][i]==-1) continue;
//            else{
//                distance[i]=graph[k][i];
//            }
////            maxTime=Math.max(maxTime,distance[i]);
//        }
//        // 直到所有的visited
//        for(int i=1;i<n;i++){
//            int min=Integer.MAX_VALUE;
//            int minNode=-1;
//            for(int j=1;j<=n;j++){
//                if(visited[j]==0 && distance[j]!=-1){
//                    if(distance[j]<min){
//                        min=distance[j];
//                        minNode=j;
//                    }
//                }
//            }
//            // 找到了当前最小距离节点minNode
//            if(minNode==-1) return -1;
//            visited[minNode]=1;
//            // update
//            for(int j=1;j<=n;j++){
//                if(visited[j]==0 && graph[minNode][j]!=-1){
//                    int i1 = graph[minNode][j] + min;
//                    if(i1<distance[j]) {
//                        distance[j]=i1;
//                    }
//                }
//            }
//        }
//        // 先检查所有的distance是否存在Integer.max 有的话 返回-1
//        for(int i=1;i<=n;i++){
//            if(distance[i]==Integer.MAX_VALUE) return -1;
//            maxTime=Math.max(maxTime,distance[i]);
//        }
//        return maxTime;
//    }
}
