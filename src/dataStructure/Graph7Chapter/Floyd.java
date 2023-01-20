package dataStructure.Graph7Chapter;

/**
 * @author Yawen Cao
 * @data 2022/1/18 11:04
 */
public class Floyd {
    // Path输出
     void printPth(int u,int v,int[][] path){
         // uv之间直达
         if(path[u][v]==-1) System.out.println(v);
         else{
             int mid=path[u][v];
             printPth(u,mid,path);
             printPth(mid,v,path);
         }
     }
}
