package dataStructure.Graph7Chapter;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2022/1/14 16:29
 * 存图方式之一---链式前向星存图 (前向:头插法)
 */
public class storeGraph {
    int[] he;
    int[] e;
    int[] ne;
    int[] w;
    // he:用于存储某个节点的头边下标 方便查找  方法是头插法
    public void add(int s,int d,int w1,int idx){
        e[idx]=d;
        ne[idx]=he[s];
        he[s]=idx;
        w[idx]=w1;
    }
    public void solution(int[][] graph,int m){
        // graph[i][2]: graph[i][0]:起点  graph[i][1]: 终点  graph[i][2]: 权重
        // 边的数量
        int n = graph.length;
        he=new int[m];
        e=new int[n];
        ne=new int[n];
        w=new int[n];
        // 初始化所有的节点的头边为-1  也就意味着所有的节点都还没有对应的边
        Arrays.fill(he,-1);
        // 初始化
        for(int i=0;i<n;i++){
            int s = graph[i][0];
            int d = graph[i][1];
            int w1 = graph[i][2];
            add(s,d,w1,i);
        }

        // 读边
        int[] visited=new int[m];
        for(int i=0;i<m;i++){
            // 如果该节点还没有被访问 则访问该节点连接的所有边
            if(visited[i]==0){
                for(int j=he[i];j!=-1;j=ne[j]){
                    // 边j指向的节点end
                    int end = e[j];
                    visited[end]=1;
                    // 取出权重 可要可不要
                    int weigh = w[j];
                }
            }
        }
    }
}
