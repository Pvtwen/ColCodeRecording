package dataStructure.Graph7Chapter;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/17 15:55
 */
public class Kruscal {
    static int[] parent;
    public static int find(int x){
        if(parent[x]!=x) parent[x]=find(parent[x]);
        return parent[x];
    }
    // edges[0],edges[1]:边的两个顶点 edges[2]: 边的权值
    public static void solution1(){
        // 对已经形成的边进行排序
        Scanner sc=new Scanner(System.in);
        // n：顶点个数 m：边的数量
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges=new int[m][3];
        int  idx=0;
        while(idx<m){
            edges[idx][0]=sc.nextInt();
            edges[idx][1]=sc.nextInt();
            edges[idx][2]=sc.nextInt();
            idx++;
        }
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        // n-1
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int cur=0;// 用来只是当前边的下标是多少
        for(int  i=1;i<=n-1;i++){
            int ver1 = edges[cur][0];int ver2=edges[cur][1];
            while(parent[find(ver1)]==parent[find(ver2)]){
                cur++;
                ver1=edges[cur][0];ver2=edges[cur][1];
            }
            // 相当于union操作 省去了定义union函数
            parent[find(ver1)]=parent[find(ver2)];
            System.out.println(ver1+" "+ver2);
        }
    }
    // 优先队列
    public static void solution(int[][] edges,int n){
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2]-o2[2];
            }
        });
        int m = edges.length;
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<m;i++){
            queue.offer(edges[i]);
        }
        for(int i=1;i<=n-1;i++){
            while(!queue.isEmpty()){
                int[] edge = queue.poll();
                int ver1=edge[0];int ver2=edge[1];
                if(parent[find(ver1)]==parent[find(ver2)]) continue;
                else {
                    parent[find(ver1)]=parent[find(ver2)];
                    System.out.println(ver1+" "+ver2);
                    break;
                }
            }
        }
    }
}
