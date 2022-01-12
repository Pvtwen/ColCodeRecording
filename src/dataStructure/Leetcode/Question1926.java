package dataStructure.Leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Yawen Cao
 * @data 2021/11/9 15:49
 * 类似于Question2045 广度优先搜索 只要第一时间找的答案直接返回 因为第一时间找到的答案一定是最优解 
 */
//  ----------------------------------------
//  |  x   .  x  x  x  x  x                      |
//  |  x   .  x   . .  .  x                   |
//  |  x   .  x   . x  .  x                   |
//  |  x   .  .  .  . .   x                   |
//  |  x  x  x  x  x  .   x                      |
// ----------------------------------------

public class Question1926 {
    // 极其错误的写法  应该避免  ！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
//    static int minStep=Integer.MAX_VALUE;
//    static int[][] dp;
//    static int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
//    public static int nearestExit(char[][] maze, int[] entrance) {
//        int x = entrance[0];
//        int y = entrance[1];
//        int n = maze.length;
//        int m = maze[0].length;
//        dp=new int[n][m];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                dp[i][j]=Integer.MAX_VALUE;
//            }
//        }
//        dfs(maze,0,x,y,entrance);
//        return minStep==Integer.MAX_VALUE?-1:minStep;
//    }
//
//    public static int dfs(char[][] maze,int step,int i,int j,int[] entrance){
//        if(maze[i][j]=='+' || (i==entrance[0] && j==entrance[1] && step!=0)) return Integer.MAX_VALUE;
//        if(dp[i][j]==Integer.MAX_VALUE && step!=0){
//            if(isBoundary(maze,i,j)) {
//                dp[i][j]=step;
//                minStep=Math.min(minStep,dp[i][j]);
//                return dp[i][j];
//            }
//        }
//        if(dp[i][j]!=Integer.MAX_VALUE){
//            if(isBoundary(maze,i,j)) minStep=Math.min(minStep,dp[i][j]);
//            else dp[i][j]=Math.min(dp[i][j],step);
//            return dp[i][j];
//        }
//        for (int[] direction : directions) {
//            int x=direction[0]+i;
//            int y=direction[1]+j;
//            if(condition(maze,x,y)) dp[i][j]=Math.min(dp[i][j],dfs(maze,step+1,x,y,entrance)-1);
//        }
//        return dp[i][j];
//    }

//    static int[][] visited;
    static int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public static int nearestExit(char[][] maze, int[] entrance) {
        int n=maze.length;
        int m=maze[0].length;
//        visited=new int[n][m];
        int entraceX = entrance[0];
        int entraceY = entrance[1];
        Deque<int[]> queue=new ArrayDeque<>();
        queue.offer(new int[]{entraceX,entraceY,0});
        while(!queue.isEmpty()){
            int[] path = queue.poll();
            int x = path[0];
            int y = path[1];
            int step = path[2];
//            visited[x][y]=1;
            maze[x][y]='+';
            for (int[] direction : directions) {
                int changeX=x+direction[0];
                int changeY=y+direction[1];
                if(condition(maze,changeX,changeY) && maze[changeX][changeY]!='+'){
                    if(isBoundary(maze,changeX,changeY)) return step+1;
                    queue.offer(new int[]{changeX,changeY,step+1});
                }
            }
        }
        return -1;
    }
    public static boolean condition(char[][] grid,int i,int j){
        return i>=0 && i<grid.length && j>=0 && j<grid[0].length;
    }
    public static boolean isBoundary(char[][] maze,int x,int y){
        return x==0 || x==maze.length-1 || y==0 || y==maze[0].length-1;
    }
}
