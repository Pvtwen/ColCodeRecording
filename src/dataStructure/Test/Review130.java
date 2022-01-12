package dataStructure.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Yawen Cao
 * @data 2021/9/27 16:03
 */
public class Review130 {
//    int[][] directions=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
//    public void solve(char[][] board) {
//        int n=board.length;
//        int m=board[0].length;
//
//        int res=0;
//
//        for(int i=0;i<m;i++){
//            if(board[0][i]=='O') dfs(board,0,i);
//            if(board[n-1][i]=='O') dfs(board,n-1,i);
//        }
//
//        for(int i=1;i<n-1;i++){
//            if(board[i][0]=='O') dfs(board,i,0);
//            if(board[i][m-1]=='O') dfs(board,i,m-1);
//        }
//
//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                if(board[i][j]=='O') board[i][j]='X';
//                if(board[i][j]=='1') board[i][j]='O';
//            }
//        }
//    }
//    public void dfs(char[][] board,int i,int j){
//        if(board[i][j]!='O') return;
//        board[i][j]='1';
//
//        for (int[] direction : directions) {
//            int x=i+direction[0];
//            int y=j+direction[1];
//            if(condition(board,x,y))
//                dfs(board,x,y);
//        }
//    }
//
//    public boolean condition(char[][]board,int x,int y){
//        return x>=0 && x<board.length && y>=0 && y<board[0].length;
//    }

    //BFS
    int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        Queue<int[]> queue=new LinkedList<>();

        for(int i=0;i<m;i++){
            if(board[0][i]=='O') queue.offer(new int[]{0,i});
            if(board[n-1][i]=='O') queue.offer(new int[]{n-1,i});
        }

        for(int i=1;i<n-1;i++){
            if(board[i][0]=='O') queue.offer(new int[]{i,0});
            if(board[i][m-1]=='O') queue.offer(new int[]{i,m-1});
        }

        while(!queue.isEmpty()){
            int[] index = queue.poll();
            int i=index[0];
            int j =index[1];

            board[i][j]='1';

            for (int[] direction : directions) {
                int x=i+direction[0];
                int y=j+direction[1];
                if(condition(board,x,y) && board[x][y]=='O') queue.offer(new int[]{x,y});
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O') board[i][j]='X';
                if(board[i][j]=='1') board[i][j]='O';
            }
        }
    }

    public boolean condition(char[][]board,int x,int y){
        return x>=0 && x<board.length && y>=0 && y<board[0].length;
    }
}
