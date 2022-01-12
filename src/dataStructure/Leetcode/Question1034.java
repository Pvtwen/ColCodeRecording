package dataStructure.Leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2021/12/7 9:28
 */
public class Question1034 {
    boolean[][] visited;
    //    boolean[][] flag;
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int[][] counts;
    //BFS
//    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
//        Deque<int[]> queue=new ArrayDeque<>();
//        int n=grid.length;
//        int m=grid[0].length;
//        visited = new boolean[n][m];
////        flag=new boolean[n][m];
//        List<int[]> list=new ArrayList<>();
//        int val = grid[row][col];
//        if(val==color) return grid;
//        queue.offer(new int[]{row,col});
//        while(!queue.isEmpty()){
//            int[] node = queue.pop();
//            int x = node[0];
//            int y = node[1];
//            visited[x][y]=true;
////            if(isBorder(grid,x,y,val)) flag[x][y]=true;
//            if(isBorder(grid,x,y,val)) list.add(new int[]{x,y});
//            for (int[] direction : directions) {
//                int changeX = direction[0] + x;
//                int changeY = direction[1] + y;
//                if (condition(grid, changeX, changeY) && !visited[changeX][changeY] && grid[changeX][changeY] == val) {
//                    queue.offer(new int[]{changeX,changeY});
//                }
//            }
//        }
////        for(int i=0;i<n;i++){
////            for(int j=0;j<m;j++){
////                if(flag[i][j]) grid[i][j]=color;
////            }
////        }
//        for (int[] posit : list) {
//            int x = posit[0];
//            int y = posit[1];
//            grid[x][y]=color;
//        }
//        return grid;
//    }
    public boolean isBorder(int[][] grid,int x,int y,int val){
        return x==0 || y==0 || x==grid.length-1 || y==grid[0].length-1 || grid[x+1][y]!=val || grid[x-1][y]!=val || grid[x][y+1]!=val || grid[x][y-1]!=val;
    }
    public boolean condition(int[][] grid,int i,int j){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length;
    }

    // DFS
//    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
//        int n=grid.length;
//        int m = grid[0].length;
//        visited = new boolean[n][m];
//        // 给定下标的值
//        int val = grid[row][col];
//        // 如果给的点的值等于要着的颜色 可以直接返回 因为根据题意 只有与给定点的颜色相同才有被判定为边界的资格。一旦颜色相同了 边界的颜色就是color 所以可以直接返回了  但是该条件可要可不要
//        if(val==color) return grid;
//        dfs(grid,val,color,row,col);
//        return grid;
//    }
//
//    public void dfs(int[][] grid, int val, int color, int i, int j) {
//        // 如果下标越界 或者 与初始点的值不相同 或者 该点被访问过 都不能成为边界
//        if (!condition(grid, i, j) || grid[i][j] != val || visited[i][j]) return;
//        visited[i][j] = true;
//        boolean border = false;
//        // 之前已经判断过conditino下标没有越界
//        // 其次，如果是grid的边界，那么一定是连分量的边界
//        // 最后，如果该点的任意一个方向不为初始点的值，那么该点肯定是位于边界上的，因为如果不是边界，四面的值都应该是col
//        if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1 || grid[i + 1][j] != val || grid[i][j + 1] != val || grid[i - 1][j] != val || grid[i][j - 1] != val)
//            border = true;
//        // dfs四个方向
//        for (int[] direction : directions) {
//            int changeX = direction[0] + i;
//            int changeY = direction[1] + j;
//            dfs(grid, val, color, changeX, changeY);
//        }
//        if (border) grid[i][j] = color;
//    }
}
