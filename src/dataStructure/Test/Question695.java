package dataStructure.Test;

/**
 * @author Yawen Cao
 * @data 2021/9/27 16:34
 */
public class Question695 {
    int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    boolean[][] visited;
    int sum=0;
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int res=0;
        visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if((!visited[i][j]) && (grid[i][j]==1)) {
                    dfs(grid, i, j);
                    res=Math.max(res,sum);
                    sum=0;
                }
            }
        }

        return res;
    }

    public void dfs(int[][] grid,int i,int j){
        if(grid[i][j]==0) return ;
        visited[i][j]=true;
        sum++;
        for (int[] direction : directions) {
            int x=direction[0]+i;
            int y=direction[1]+j;
            if(condition(grid,x,y) && !visited[x][y]) {
                dfs(grid, x, y);
            }
        }
    }

    public int dfs(int[][] grid,int i,int j,int res){
        if(grid[i][j]==0) return res;
        visited[i][j]=true;
        res++;
        for (int[] direction : directions) {
            int x=direction[0]+i;
            int y=direction[1]+j;
            if(condition(grid,x,y) && !visited[x][y]) {
                res=dfs(grid, x, y,res);
            }
        }
        return res;
    }

    public boolean condition(int[][]board,int x,int y){
        return x>=0 && x<board.length && y>=0 && y<board[0].length;
    }

}
