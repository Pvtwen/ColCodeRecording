package dataStructure.Graph7Chapter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/11/27 16:40
 * dfs遍历无向图
 */
public class p741 {
    int[] visited;
    public void DFSForest(int num,int[][] con){
        visited=new int[num];
        ArrayList<Integer>[] list= new ArrayList[num];
        for(int i=0;i<num;i++){
            list[i]=new ArrayList<>();
        }
        int length = con.length;
        for(int i=0;i<length;i++){
            int i1 = con[i][0];
            int i2 = con[i][1];
            list[i1].add(i2);
            list[i2].add(i1);
        }
        for(int i=0;i<num;i++){
            if(visited[i]==0){
                ArrayList<Integer> li = new ArrayList<>();
                li.add(i);
                dfs(i,list,li);
                for (Integer node : li) {
                    System.out.print(node);
                    System.out.println();
                }
            }
        }
    }
    public void dfs(int node,ArrayList<Integer>[] list, List<Integer> li){
        visited[node]=1;
        for (Integer neigh : list[node]) {
            if(visited[neigh]!=0) continue;
            dfs(neigh,list,li);
        }
        li.add(node);
    }
}
