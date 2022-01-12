package dataStructure.Compute;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/11/9 14:54
 * BFS只能判断有无一条路径可以到达终点 但是DFS可以找到所有的路径
 */
public class mazeBFS {
    static int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public static boolean solution(int[][] grid){
        Deque<int[]> queue=new ArrayDeque<>();
        int n=grid.length;
        int m=grid[0].length;
        int[][] visited=new int[n][m];
        queue.offer(new int[]{0,0});

        while(!queue.isEmpty()){
            int[] path = queue.poll();
            int x = path[0];
            int y = path[1];
            visited[x][y]=1;
            if(x==n-1 && y==m-1){
                return true;
            }
            for (int[] direction : directions) {
                int changeX=x+direction[0];
                int changeY=direction[1]+y;
                if(condition(grid,changeX,changeY) && grid[changeX][changeY]!=1 && visited[changeX][changeY]!=1){
                    queue.offer(new int[]{changeX,changeY});
                }
            }
        }
        return false;
    }
    public static boolean condition(int[][] grid,int i,int j){
        return i>=0 && i<grid.length && j>=0 && j<grid[0].length;
    }
}
