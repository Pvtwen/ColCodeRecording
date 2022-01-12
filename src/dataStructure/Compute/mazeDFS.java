package dataStructure.Compute;

import java.util.*;
/**
 * @author Yawen Cao
 * @data 2021/11/9 14:19
 * BFS只能判断有无一条路径可以到达终点 但是DFS可以找到所有的路径
 */
public class mazeDFS {
//    static int[][] visited;
    static int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public static void solution(int[][] grid){
        int n=grid.length;
        int m=grid[0].length;
//        dfs(grid,0,0,new ArrayList<>());
        dfs(grid,0,0,new LinkedHashSet<>());
    }

    public static void dfs(int[][] grid,int i,int j,Set<Map.Entry<Integer,Integer>> set){
        int n = grid.length;
        int m = grid[0].length;

        Map.Entry<Integer, Integer> entry = Map.entry(i, j);
        if(set.contains(entry)) return;
        if(grid[i][j]==1) return;
        if(i==n-1 && j==m-1){
            set.add(entry);
            showPath(set);
            System.out.println();
            return;
        }

        set.add(entry);
        for (int[] direction : directions) {
            int x=direction[0]+i;
            int y = direction[1] + j;
            if(condition(grid,x,y)){
                HashSet<Map.Entry<Integer, Integer>> copy = new LinkedHashSet<>(set);
                dfs(grid,x,y,copy);
            }
        }
    }
//    public static void dfs(int[][] grid, int i, int j, List<int[]> list){
//        int n=grid.length;
//        int m=grid[0].length;
//        if(visited[i][j]==1) return;
//        if(grid[i][j]==1) return;
//        if(i==n-1 && j==m-1){
//            list.add(new int[]{i,j});
//            showPath(list);
//        }
//        visited[i][j]=1;
//        list.add(new int[]{i,j});
//        ArrayList<int[]> copy = new ArrayList<>(list);
//
//        for (int[] direction : directions) {
//            int x=direction[0]+i;
//            int y=direction[1]+j;
//            if(condition(grid,x,y)){
//                dfs(grid,x,y,copy);
//            }
//        }
//    }
    public static boolean condition(int[][] grid,int i,int j){
        return i>=0 && i<grid.length && j>=0 && j<grid[0].length;
    }
    public static void showPath(Set<Map.Entry<Integer,Integer>> set){
        Object[] arr = set.toArray();
        int length = arr.length;

        for(int i=0;i<length;i++){
            System.out.println((i+1)+":"+arr[i]);
        }
    }
//    public static void showPath(List<int[]> list){
//        int size=list.size();
//        for(int i=0;i<size;i++){
//            int[] path = list.get(i);
//            int x = path[0];
//            int y = path[1];
//            System.out.println((i+1)+":"+x+","+y);
//        }
//    }
}
