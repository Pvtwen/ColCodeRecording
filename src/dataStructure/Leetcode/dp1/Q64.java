package dataStructure.Leetcode.dp1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.BiPredicate;

/**
 * @author Yawen Cao
 * @data 2022/2/5 10:36
 * 数塔
 */
public class Q64 {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp=new int[n][m];
        for (int[] ints : dp) {
            Arrays.fill(ints,Integer.MAX_VALUE);
        }
        dp[n-1][m-1]=grid[n-1][m-1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1) continue;
                if(i==n-1){
                    dp[i][j]=grid[i][j]+dp[i][j+1];
                }
                else if(j==m-1){
                    dp[i][j]=grid[i][j]+dp[i+1][j];
                }else{
                    dp[i][j]=grid[i][j]+Math.min(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
//    int[][] directions={{1,0},{0,1}};
//    public int minPathSum(int[][] grid) {
//        return dfs(grid,0,0);
//    }
//    HashMap<String,Integer> map=new HashMap<>();
//    public int dfs(int[][] grid,int i,int j){
//        if(i+1==grid.length && j+1==grid[0].length){
//            return grid[i][j];
//        }
//        String cur=i+","+j;
//        int sum=Integer.MAX_VALUE;
//        if(map.containsKey(cur)) return map.get(cur);
//        for (int[] direction : directions) {
//            int x= direction[0]+i;
//            int y=direction[1]+j;
//            if(condition(grid,x,y)){
//                sum=Math.min(sum,grid[i][j]+dfs(grid,x,y));
//            }
//        }
//        map.put(cur,sum);
//        return sum;
//    }
//    public int minPathSum(int[][] grid) {
//        return dfs(grid,0,0);
//    }
//    public int dfs(int[][] grid,int i,int j){
//        if(i+1==grid.length && j+1==grid[0].length){
//            return grid[i][j];
//        }
//        int cur=Integer.MAX_VALUE;
//        for (int[] direction : directions) {
//            int x=direction[0]+i;
//            int y=direction[1]+j;
//            if(condition(grid,x,y)) {
//                cur=Math.min(cur,grid[i][j]+dfs(grid,x,y));
//            }
//        }
//        return cur;
//    }

//    public int minPathSum(int[][] grid) {
//        dfs(grid,0,0,0);
//        return ret;
//    }
//    int ret=Integer.MAX_VALUE;
//    public void dfs(int[][] grid,int sum,int i,int j){
//        if(i+1==grid.length && j+1==grid[0].length){
//            ret=Math.min(ret,sum+grid[i][j]);
//            return;
//        }
//        for (int[] direction : directions) {
//            int x=direction[0]+i;
//            int y=direction[1]+j;
//            if(condition(grid,x,y)) dfs(grid,sum+grid[i][j],x,y);
//        }
//    }
    public boolean condition(int[][] grid,int i,int j){
        return i>=0 && i<grid.length && j>=0 && j<grid[0].length;
    }
}
