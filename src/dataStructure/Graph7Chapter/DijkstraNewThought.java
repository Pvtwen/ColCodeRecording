package dataStructure.Graph7Chapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/12/22 11:27
 */
public class DijkstraNewThought {
    int[] mVex;
    int[][] nMatrix;    // 邻接矩阵

    public void dij(int vs, int[] prev, int[] dist, int[][] condition) {
        int n = mVex.length;    // 顶点个数
        nMatrix=new int[n+1][n+1];
        int length = condition.length;
        for(int i=0;i<length;i++){
            int pre = condition[i][0];
            int nex = condition[i][1];
            int weigh = condition[i][2];
            nMatrix[pre][nex]=weigh;
        }
        // 存放已经知道最小距离的节点的数组
        boolean[] flag = new boolean[n + 1];
        flag[vs]=true;
        for(int i=1;i<=n;i++){
            int weigh = nMatrix[vs][i];
            dist[vs]=weigh;
            flag[i]=false;
            prev[i]=-1;
            if(weigh!=0){
                prev[i]=vs;
            }
        }
        prev[vs]=vs;

        int k=-1;
        for(int i=1;i<=n;i++){
            int min=Integer.MAX_VALUE;
            for(int j=1;j<n;j++){
                if(!flag[j] && dist[j]<min){
                    min=dist[j];
                    k=j;
                }
            }
            // k为比较之后的最短路径的下标
            flag[k]=true;
            // 更新k连接的所有节点
            for (int j = 1; j <= n; j++) {
                // 如果节点k到j是可达的 和dist[j]比较
                // 如果比dist[j]小，则更新
                if(nMatrix[k][j]!=0 && flag[j]==false){
                    if(dist[k]+nMatrix[k][j]<dist[j]){
                        dist[j] = dist[k] + nMatrix[k][j];
                        prev[j]=k;
                    }
                }
            }
        }

        // 根据prev查询每个节点的最短路径
        for(int i=1;i<=n;i++){
            System.out.println("节点"+i+"的最短路径为");
            List<Integer> step = new ArrayList<>();
            step.add(i);
            int tmp=i;
            while (prev[tmp] != vs) {
                tmp=prev[tmp];
                step.add(tmp);
            }
            Collections.sort(step);
            for (Integer integer : step) {
                System.out.println(integer);
            }
        }
    }
}
