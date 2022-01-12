package dataStructure.Leetcode;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 86153
 * @data 2021/8/16 9:49
 */
public class Question200 {
    static final int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][] visited;
    public int numIslands(char[][] grid) {
        int num=0;
        //行
        int m=grid.length;
        //列
        int n=grid[0].length;
        // 状态函数
        visited=new boolean[m][n];
        //遍历数组
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // 如果没有访问过该元素 且 这个元素为1 则dfs，岛屿数量+1
                if(!visited[i][j] && grid[i][j]=='1'){
                    num++;
                    dfs(grid,i,j);
                }
            }
        }
        return num;
    }
    public void dfs(char[][] grid,int i,int j){
        // 如果是0 回溯
        if(grid[i][j]=='0') return;
        // 为1 先将状态函数置为 已访问过
        visited[i][j]=true;
        // 深度优先四个方向
        for (int[] direction : directions) {
            int changeX=direction[0]+i;
            int changeY=direction[1]+j;
            if(condition(grid,changeX,changeY) && visited[changeX][changeY]!=true){
                dfs(grid,changeX,changeY);
            }
        }
    }
    // 判断是否越界
    public boolean condition(char[][] grid,int i,int j){
        return i>=0 && i<grid.length && j>=0 && j<grid[0].length;
    }

    //BFS
//    static final int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};
//    static boolean[][] visited;
//    public int numIslands(char[][] grid) {
//        int num=0;
//        // 用队列存储 元素的坐标
//        Queue<int[]> queue=new LinkedList<>();
//        visited=new boolean[grid.length][grid[0].length];
//        for(int i=0;i<grid.length;i++){
//            for(int j=0;j<grid[0].length;j++){
//                // 如果是0则continue
//                if(visited[i][j]==false && grid[i][j]=='1'){
//                    num++;
//                    //入队列 置为true
//                    queue.offer(new int[]{i,j});
//                    visited[i][j]=true;
//                    // 遍历队列
//                    while(!queue.isEmpty()){
//                        int[] point = queue.poll();
//                        int x=point[0];
//                        int y=point[1];
//                        for (int[] direction : directions) {
//                            int changeX=direction[0]+x;
//                            int changeY=direction[1]+y;
//                            //如果没有越界
//                            if(condition(grid,changeX,changeY)){
//                                //如果是0 则下一个方向
//                            if(grid[changeX][changeY]=='1' && visited[changeX][changeY]==false){
//                                queue.offer(new int[]{changeX,changeY});
//                                visited[changeX][changeY]=true;
//                            }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return num;
//    }
//    //判断是否越界
//    public boolean condition(char[][] grid,int i,int j){
//        return i>=0 && i<grid.length && j>=0 && j<grid[0].length;
//    }

    //并查集
//    static int[][] directions={{0,1},{1,0}};
//    static class Union{
//        int count;
//        int[] rank;
//        int[] parent;
//        public Union(char[][] grid){
//            count=0;
//            int m=grid.length;
//            int n=grid[0].length;
//            rank=new int[m*n];
//            parent=new int[m*n];
//            for(int i=0;i<m;i++){
//                for(int j=0;j<n;j++){
//                    if(grid[i][j]=='1'){
//                        count++;
//                        parent[i*n+j]=i*n+j;
//                        rank[i*n+j]=0;
//                    }
//                }
//            }
//        }
//
//        public int find(int x){
//            //路径优化 1
//            if(x!=parent[x]) parent[x]=find(parent[x]);
//            return parent[x];
//        }
//
//        public void union(int i,int j){
//            int rootx = find(i);
//            int rooty = find(j);
//            if(rootx!=rooty){
//                if(rank[rootx]>rank[rooty]) parent[rooty]=rootx;
//                else if(rank[rootx]<rank[rooty]) parent[rootx]=rooty;
//                else{
//                    parent[rooty]=rootx;
//                    rank[rootx]+=1;
//                }
//                count--;
//            }
//        }
//    }
//    public static int numIslands(char[][] grid) {
//        int m=grid.length;
//        int n=grid[0].length;
//
//        Union uf=new Union(grid);
//
//        for(int i=0;i<grid.length;i++){
//            for(int j=0;j<grid[0].length;j++){
//                if(grid[i][j]=='1'){
////                    grid[i][j]='0';
//                    for (int[] direction : directions) {
//                        int changeX=direction[0]+i;
//                        int changeY=direction[1]+j;
//                        if(condition(grid,changeX,changeY) && grid[changeX][changeY]!='0'){
//                            uf.union(i*n+j,changeX*n+changeY);
//                        }
//                    }
//                }
//            }
//        }
//        return uf.count;
//    }
//    public static boolean condition(char[][] grid,int x,int y){
//        return x>=0 && x<grid.length && y>=0 && y<grid[0].length;
//    }
}