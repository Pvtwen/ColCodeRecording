package dataStructure.Graph7Chapter;

/**
 * @author Yawen Cao
 * @data 2022/2/17 15:09
 */
public class Prime {
    // G为邻接绝阵 u为开始的顶点
    // 书上用G.vexs[i]来指代图中的第几个顶点是哪个顶点。这里为了方便直接用下标代替第几个顶点.
    public static void solution(int[][] G,int u){
        int n = G.length;
        // [0]:哪个顶点到该点的边权值最小 [1]:该条边的权值是多少
        int[][] closegde=new int[n][2];
        // 假设不可达为负无穷
        for(int i=0;i<n;i++){
            if(i!=u) {
                closegde[i][0]=u;
                closegde[i][1]=G[u][i];
            }
        }
        // 为0表示已经到达
        closegde[u][1]=0;
        System.out.println(u);
        // 还剩下n-1个顶点
        for(int i=1;i<n;i++){
            // 找最小的顶点
            int minCost= (int) 1e8;
            int minVertex=-1;

            for(int j=0;j<n;j++){
                if(closegde[j][1]==0) continue;
                if(closegde[j][1]<minCost){
                    minCost=closegde[j][1];
                    minVertex=j;
                }
            }
            // 输出生成树的边
            System.out.println(closegde[minVertex][0]+" "+minVertex);
            closegde[minVertex][1]=0;
            for(int k=0;k<n;k++){
                if(G[minVertex][k]<closegde[k][1]){
                    closegde[k][1]=G[minVertex][k];
                    closegde[k][0]=minVertex;
                }
            }
        }
    }
}
