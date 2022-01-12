package dataStructure.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * @author Yawen Cao
 * @data 2021/10/21 17:05
 */
public class Question886Review {
//    class unionFind{
//        int[] parent;
//
//        public unionFind(int n){
//            parent=new int[n+1];
//            for(int i=1;i<=n;i++){
//                parent[i]=i;
//            }
//        }
//
//        public int find(int x){
//            if(parent[x]!=x)parent[x]=find(parent[x]);
//            return parent[x];
//        }
//
//        public void union(int x,int y){
//            int rootx = find(x);
//            int rooty = find(y);
//            parent[rooty]=rootx;
//        }
//    }
//    public static boolean possibleBipartition(int n, int[][] dislikes) {
//        int length=dislikes.length;
//
//        Queue<Integer> queue=new ArrayDeque<>();
//        ArrayList<Integer>[] list=new ArrayList[n+1];
//
//        for(int i=1;i<=n;i++){
//            list[i]=new ArrayList<>();
//        }
//        for(int i=0;i<length;i++){
//            int a = dislikes[i][0];
//            int b = dislikes[i][1];
//            list[a].add(b);
//            list[b].add(a);
//        }
//
//        int[] colors=new int[n+1];
//        for(int i=1;i<=n;i++){
//            if(colors[i]!=0) continue;
//            queue.offer(i);
//            colors[i]=1;
//            while(!queue.isEmpty()){
//                Integer poll = queue.poll();
//                int color = colors[poll];
//                int nextColor=(color==1)?2:1;
//                for (Integer next : list[poll]) {
//                    if(colors[next]==0) {
//                        colors[next]=nextColor;
//                        // 不加这一句话 遍历到2，3时 直接跳过
//                        queue.offer(next);
//                    }
//                    else{
//                        if(colors[next]!=nextColor) return false;
//                    }
//                }
//            }
//        }
//        return true;
//    }

    //dfs
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        int length=dislikes.length;
        int[] colors=new int[n+1];
        ArrayList<Integer>[] list=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i]=new ArrayList<>();
        }
        for(int i=0;i<length;i++){
            int a = dislikes[i][0];
            int b = dislikes[i][1];
            list[a].add(b);
            list[b].add(a);
        }

        for(int i=1;i<=n;i++){
            if(colors[i]!=0) continue;
            else{
                colors[i]=1;
                if(!dfs(i,colors,1,list)) return false;
            }
        }
        return true;
    }
    public static boolean dfs(int node,int[] colors,int color,ArrayList<Integer>[] list){
        int nextColor=(color==1)?2:1;
        for (Integer nextNode : list[node]) {
            if(colors[nextNode]==0) {
                colors[nextNode]=nextColor;
                if(!dfs(nextNode,colors,nextColor,list)) return false;
            }else if(colors[nextNode]!=nextColor) return false;
        }
        return true;
    }
}
