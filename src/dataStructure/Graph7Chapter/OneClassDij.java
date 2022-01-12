package dataStructure.Graph7Chapter;

import java.util.ArrayList;

/**
 * @author Yawen Cao
 * @data 2021/11/29 16:32
 */
public class OneClassDij {
    int[] mVexs;//顶点集合
    int[][] nMatrix;// 邻接矩阵
    ArrayList<Integer>[] list; // 邻接表 无法知道权值
    // vs 起始顶点
    // prev 函数结束时，该数组代表到达该节点的最短路径的前一个结点
    // dist 函数结束时 该数组中的值为到达该节点的最短值
    public void dijtsra(int vs,int[] prev,int[] dist,int[][] condition){
        int num = mVexs.length;
        // 根据condition给nmatrix赋值
        int length = condition.length;
        for(int i=0;i<length;i++){
            int pre = condition[i][0];
            int cur = condition[i][1];
            int weigh = condition[i][2];
            nMatrix[pre][cur]=weigh;
        }
        nMatrix=new int[num][num];

        boolean[] flag=new boolean[num];
        // init
        for(int i=0;i<num;i++){
            flag[i]=false;
            prev[i]=-1;
            dist[i]=nMatrix[vs][i];
            // 这里提前赋值前驱节点的道理和下面类似
            if(dist[i]!=Integer.MAX_VALUE){
                prev[i]=vs;
            }
        }
        flag[vs]=true;
        prev[vs]=vs;

        int k=-1;
        for(int i=1;i<num;i++){
            int min=Integer.MAX_VALUE;
            for(int j=0;j<num;j++){
                if(flag[j]==false && dist[j]<min){
                    min=dist[j];
                    k=j;
                }
            }
            // 此时下标为k的节点就是 最段路径
            flag[k]=true;
            for(int j=0;j<num;j++){
                int tmp=(nMatrix[k][j]==Integer.MAX_VALUE)?Integer.MAX_VALUE:(min+nMatrix[k][j]);
                if(flag[j]==false && dist[j]>tmp){
                    dist[j]=tmp;
                    // 不一定是最短路径 但是先将前驱节点设置为k 否则后面找最小值的时候 不能够赋值  因为不知道前驱节点
                    prev[j]=k;
                }
            }
        }
    }
}