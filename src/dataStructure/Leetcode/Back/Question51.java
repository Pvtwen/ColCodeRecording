package dataStructure.Leetcode.Back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yawen Cao
 * @data 2022/1/7 15:13
 */
public class Question51 {
    List<List<String>> ret=new ArrayList<>();
    boolean[][] visited;
    public List<List<String>> solveNQueens(int n) {
        char[][] arr=new char[n][n];
        // initial arr
        for (char[] chars : arr) {
            Arrays.fill(chars,'.');
        }
        visited= new boolean[3][2*n];
        dfs(n,arr,0);
        return ret;
    }
    // cur:层数
    public void dfs(int n,char[][] arr,int cur){
        if(cur==n){
            List<String> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                String s="";
                for (char c : arr[i]) {
                    s+=c;
                }
                list.add(s);
            }
            ret.add(list);
        }
        for(int i=0;i<n;i++){
            if(!visited[0][i] && !visited[1][cur+i] && !visited[2][cur-i+n]){
                visited[0][i]=visited[1][cur+i]=visited[2][cur-i+n]=true;
                arr[cur][i]='Q';
                dfs(n,arr,cur+1);
                arr[cur][i]='.';
                visited[0][i]=visited[1][cur+i]=visited[2][cur-i+n]=false;
            }
        }
    }
}
