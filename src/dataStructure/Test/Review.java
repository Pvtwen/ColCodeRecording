package dataStructure.Test;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 86153
 * @data 2021/8/11 10:14
 */
class Review {
    static final int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited=new boolean[board.length][board[0].length];

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                //  返回值为false  则状态重置(begin置为0 i,j)
                if(dfs(board,word,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,String word,int i,int j,int begin){
        // 如果匹配到最后一个字符  相等则返回true  不相等则返回false
        if(begin==word.length()-1){
            return board[i][j]==word.charAt(begin);
        }
        if(board[i][j]==word.charAt(begin)){
            // 如果两者相等 则将状态变量置为true 访问过
            visited[i][j]=true;
            for (int[] direction : directions) {
                int changeX=direction[0]+i;
                int changeY=direction[1]+j;
                if(condition(board,changeX,changeY) && !visited[changeX][changeY]){
                    if(dfs(board,word,changeX,changeY,begin+1)){
                        return true;
                    }
                }
            }
            // 状态重置为false 表示没访问过
            visited[i][j]=false;
        }
        //如果四个方向循环完了之后都没有匹配到 或者是该字符本身就不匹配 那么回溯
        return false;
    }

    public boolean condition(char[][] board,int i,int j){
        return i>=0 && i<board.length && j>=0 && j<board[0].length;
    }
}

