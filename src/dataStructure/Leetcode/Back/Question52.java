package dataStructure.Leetcode.Back;

import java.util.Arrays;

/**
 * @author Yawen Cao
 * @data 2022/1/7 15:28
 */
public class Question52 {
    int tot=0;
    boolean[][] visited;
    public int totalNQueens(int n) {
        char[][] arr=new char[n][n];
        visited=new boolean[3][2*n];
        for (char[] chars : arr) {
            Arrays.fill(chars,'.');
        }
        dfs(n,0,arr);
        return tot;
    }
    public void dfs(int n,int cur,char[][] arr){
        if (cur == n) {
            tot++;
            return;
        }
        for(int  i=0;i<n;i++){
            if(!visited[0][i] && !visited[1][cur+i] && !visited[2][cur-i+n]){
                visited[0][i]=visited[1][cur+i]=visited[2][cur-i+n]=true;
                arr[cur][i]='Q';
                dfs(n,cur+1,arr);
                visited[0][i]=visited[1][cur+i]=visited[2][cur-i+n]=false;
                arr[cur][i]='.';
            }
        }
    }
}
