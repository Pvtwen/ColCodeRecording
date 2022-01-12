package dataStructure.Leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 86153
 * @data 2021/8/14 11:43
 */
public class Question130 {
//    static final int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};
//    public static void solve(char[][] board){
//        int m=board[0].length;
//        int n=board.length;
//        for(int i=0;i<m;i++){
//            dfs(board,0,i);
//            dfs(board,n-1,i);
//        }
//        for(int j=1;j<n-1;j++){
//            dfs(board,j,0);
//            dfs(board,j,m-1);
//        }
//
//        for(int i=0;i<m;i++){
//            for(int j=0;j<n;j++){
//                if(board[i][j]=='A'){
//                    board[i][j]='O';
//                }else if(board[i][j]=='O'){
//                    board[i][j]='X';
//                }
//            }
//        }
//    }
//
//    public static void dfs(char[][] board,int i,int j){
//        if(condition(board,i,j)){
//            return;
//        }
//        board[i][j]='A';
//        for (int[] direction : directions) {
//            int changeX=direction[0]+i;
//            int changeY=direction[1]+j;
//            dfs(board,changeX,changeY);
//        }
//    }
//
//    public static boolean condition(char[][] board,int i,int j){
//        return i<0 || i>=board[0].length || j<0 || j>=board.length || board[i][j]!='O';
//    }

    //BFS
    static int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};
    public void solve(char[][] board){
        int m=board.length;
        // 列数
        int n=board[0].length;
        Queue<int[]> queue=new LinkedList<>();

        // 前两个for循环遍历边界的O元素 将其坐标加入队列
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                board[i][0]='A';
                queue.offer(new int[]{i,0});
            }
            if(board[i][n-1]=='O'){
                board[i][n-1]='A';
                queue.offer(new int[]{i,n-1});
            }
        }


        for(int j=1;j<n-1;j++){
            if(board[0][j]=='O'){
                board[0][j]='A';
                queue.offer(new int[]{0,j});
            }
            if(board[m-1][j]=='O'){
                board[m-1][j]='A';
                queue.offer(new int[]{m-1,j});
            }
        }

        // 队列抛出元素 每抛出一个元素  先广度搜索其四周的元素是否为O  如果是  将O先加入队列当中
        // 此处注意区分广度和深度的区别
        while(!queue.isEmpty()){
            int[] point = queue.poll();
            int x=point[0];
            int y=point[1];
            for (int[] direction : directions) {
                int changeX=direction[0]+x;
                int changeY=direction[1]+y;
                if(condition(board,changeX,changeY)){
                    continue;
                }
                board[changeX][changeY]='A';
                queue.offer(new int[]{changeX,changeY});
            }
        }
        // 循环遍历  将A-》O  O->X
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='A'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    public boolean condition(char[][] board,int x,int y){
        return x<0 || x>=board.length || y<0 || y>=board[0].length || board[x][y]!='O';
    }
}
