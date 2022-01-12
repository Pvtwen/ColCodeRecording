package dataStructure.Leetcode.GridDfsAndBfsAndUf;

/**
 * @author Yawen Cao
 * @data 2021/12/7 15:03
 */
public class Question419Review {
    boolean[][] visited;
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    int ret=0;
    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] != '.') {
                    ret++;
                    dfs(board, i, j);
                }
            }
        }
        return ret;
    }
    public void dfs(char[][] board,int i,int j){
        if(visited[i][j] || board[i][j]!='X') return;
        visited[i][j]=true;

        for (int[] direction : directions) {
            int changeX = direction[0] + i;
            int changeY = direction[1] + j;
            if(condition(board,changeX,changeY)){
                dfs(board,changeX,changeY);
            }
        }
    }
    public boolean condition(char[][] grid,int i,int j){
        return i>=0 && j>=0 && i<grid.length && j<grid[0].length;
    }
}
