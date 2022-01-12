package dataStructure.Leetcode;

import java.awt.datatransfer.Clipboard;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 86153
 * @data 2021/8/13 11:26
 */
public class Question79 {
    // dfs
//    static final int[][] directions={{-1,0},{0,1},{1,0},{0,-1}};
//    static boolean[][] visited;
//    public static boolean exist(char[][] board, String word) {
//        visited=new boolean[board.length][board[0].length];
//        for(int i=0;i<board.length;i++){
//            for(int j=0;j<board[0].length;j++){
//                // 只要返回值为false, 则状态重置 depth重置为0
//                if(dfs(board,word,i,j,0)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//    public static boolean dfs(char[][] board,String word,int i,int j,int depth){
//        if(depth==word.length()-1){
//            return board[i][j]==word.charAt(depth);
//        }
//        if(board[i][j]==word.charAt(depth)){
//            visited[i][j]=true;
//            for (int[] direction : directions) {
//                int changeX=direction[0]+i;
//                int changeY=direction[1]+j;
//                if(condition(board,changeX,changeY) && !visited[changeX][changeY]){
//                    if(dfs(board,word,changeX,changeY,depth+1)){
//                        return true;
//                    }
//                }
//            }
//            visited[i][j]=false;
//        }
//        return false;
//    }
//    public static boolean condition(char[][] board,int i,int j){
//        return i>=0 && i<board.length && j>=0 && j<board[0].length;
//    }



}
