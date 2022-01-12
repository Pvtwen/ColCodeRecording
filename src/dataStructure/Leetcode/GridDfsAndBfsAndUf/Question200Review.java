package dataStructure.Leetcode.GridDfsAndBfsAndUf;

import java.util.*;

/**
 * @author Yawen Cao
 * @data 2021/12/7 10:16
 */
public class Question200Review {
    int num=0;
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean[][] visited;

    //BFS
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
//        visited=new boolean[n][m];
        Deque<int[]> queue = new ArrayDeque<>();
        Set<Long> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!set.contains(hash(i,j)) && grid[i][j]!='0'){
                    num++;
                    queue.offer(new int[]{i, j});
                    set.add(hash(i,j));
                    while(!queue.isEmpty()){
                        int[] poll = queue.poll();
                        int x = poll[0];
                        int y = poll[1];
                        for (int[] direction : directions) {
                            int changeX = direction[0] + x;
                            int changeY = direction[1] + y;
                            if(condition(grid,changeX,changeY) && !set.contains(hash(changeX,changeY)) && grid[changeX][changeY]!='0'){
                                queue.offer(new int[]{changeX,changeY});
                                set.add(hash(changeX,changeY));
                            }
                        }
                    }
                }
            }
        }
        return num;
    }
    public Long hash(int x,int y){
        return x+y*10000L;
    }
    // DFS
//    public int numIslands(char[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        visited=new boolean[n][m];
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(grid[i][j]=='1' && !visited[i][j]){
//                    num++;
//                    dfs(grid,i,j,visited);
//                }
//            }
//        }
//        return num;
//    }
//    public void dfs(char[][] grid,int x,int y,boolean[][] visited){
//        if(!condition(grid,x,y) || grid[x][y]=='0' || visited[x][y]) return;
//        visited[x][y]=true;
//        for (int[] direction : directions) {
//            int changeX = direction[0] + x;
//            int changeY = direction[1] + y;
//            dfs(grid,changeX,changeY,visited);
//        }
//    }
    public boolean condition(char[][] grid,int i,int j){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length;
    }
}
