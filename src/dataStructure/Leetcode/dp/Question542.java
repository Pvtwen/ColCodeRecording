package dataStructure.Leetcode.dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Yawen Cao
 * @data 2021/12/30 11:42
 */
public class Question542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp=new int[m][n];
        for (int[] ints : dp) {
            Arrays.fill(ints,Integer.MAX_VALUE/2);
        }
        // 左上到右下
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0) dp[i][j]=0;
                else{
                    if(i>0) dp[i][j]=Math.min(dp[i-1][j]+1,dp[i][j]);
                    if(j>0) dp[i][j]=Math.min(dp[i][j],dp[i][j-1]+1);
                }
            }
        }
        // 右下到左上
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(mat[i][j]==0) dp[i][j]=0;
                else{
                    if(i<m-1) dp[i][j]=Math.min(dp[i][j],dp[i+1][j]+1);
                    if(j<n-1) dp[i][j]=Math.min(dp[i][j],dp[i][j+1]+1);
                }
            }
        }
        return dp;
    }
//    int[][] distance;
//    boolean[][] visited;
//    int[][] directions={{0,1},{1,0},{-1,0},{0,-1}};
//    public int[][] updateMatrix(int[][] mat) {
//        Deque<int[]> queue=new ArrayDeque<>();
//
//        int m = mat.length;
//        int n = mat[0].length;
//        visited= new boolean[m][n];
//        distance=new int[m][n];
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(mat[i][j]==0) {
//                    queue.offer(new int[]{i,j,0});
//                    visited[i][j]=true;
//                    distance[i][j]=0;
//                }
//            }
//        }
//        while(!queue.isEmpty()){
//            int[] coor = queue.poll();
//            int x = coor[0];
//            int y = coor[1];
//            int dist = coor[2];
//            for (int[] direction : directions) {
//                int changeX = direction[0] + x;
//                int changeY = direction[1] + y;
//                if(condition(mat,changeX,changeY)){
//                    // 没有越界 没有访问过
//                    if(!visited[changeX][changeY]){
//                        visited[changeX][changeY]=true;
//                        queue.offer(new int[]{changeX,changeY,dist+1});
//                        distance[changeX][changeY]=dist+1;
//                    }
//                }
//            }
//        }
//        return distance;
//    }

    // 最好不用dfs 由于dfs是一条路走到底，难免会错过旁边的点就是0的情况，会很麻烦
//    public int dfs(int[][] mat,int x,int y){
//        if(mat[x][y]==0) return 0;
//        if(distance[x][y]>0) return distance[x][y];
//        int dist= (int) 1e9;
//        for (int[] direction : directions) {
//            int changeX= direction[0] + x;
//            int changeY = direction[1] + y;
//            if(condition(mat,changeX,changeY)){
//                if(!visited[changeX][changeY]) {
//                    visited[changeX][changeY]=true;
//                    dist=Math.min(dist,dfs(mat,changeX,changeY)+1);
//                    visited[changeX][changeY]=false;
//                }
//            }
//        }
//        distance[x][y]=dist;
//        return dist;
//    }
    public boolean condition(int[][] mat,int x,int y){
        int n = mat.length;
        int m = mat[0].length;
        return x<n && x>=0 && y>=0 && y<m;
    }
    // 转换坐标
    public int conversion(int[][] mat,int x,int y){
        int n = mat[0].length;
        return x*n+y;
    }
    public int[] reconversion(int[][] mat,int v){
        int n = mat.length;
        int m = mat[0].length;
        int y = v % m;
        int x;
        if(y==m-1) x=v/n-1;
        else x=v/n;
        return new int[]{x,y};
    }
}
