package dataStructure.Leetcode.dp;

import java.util.HashMap;
import java.util.function.BiPredicate;

/**
 * @author Yawen Cao
 * @data 2021/12/29 9:50
 */
public class Question576 {
    int[][] directions={{-1,0},{0,1},{0,-1},{1,0}};
    int MOD= (int) (1e9+7);
    public boolean condition(int m,int n,int row,int col){
        return row>=0 &&col>=0 && row<m && col<n;
    }
    // dp优化
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[] dp=new int[m*n];

        for(int k=1;k<=maxMove;k++){
            int[] temp=new int[m*n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    int idx=i*n+j;
                    if(i==0) temp[idx]++;
                    if(j==0) temp[idx]++;
                    if(i==m-1) temp[idx]++;
                    if(j==n-1) temp[idx]++;
                    for (int[] direction : directions) {
                        int changeX=direction[0]+i;
                        int changeY=direction[1]+j;
                        int changeIdx=changeX*n+changeY;
                        if(condition(m,n,changeX,changeY))
                        temp[idx]=(temp[idx]+dp[changeIdx])%MOD;
                    }
                }
            }
            dp=temp;
        }
        int dest=startRow*n+startColumn;
        return dp[dest];
    }
//    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//        int[][][] dp=new int[m][n][maxMove+1];
//
//        for(int k=1;k<=maxMove;k++){
//            for(int i=0;i<m;i++){
//                for(int j=0;j<n;j++){
//                    if(i==0) dp[i][j][k]++;
//                    if(j==0)dp[i][j][k]++;
//                    if(i==m-1)dp[i][j][k]++;
//                    if(j==n-1)dp[i][j][k]++;
//
//                    for (int[] direction : directions) {
//                        int changeX=direction[0]+i;
//                        int changeY=direction[1]+j;
//                        if(condition(m,n,changeX,changeY))dp[i][j][k]=(dp[i][j][k]+dp[changeX][changeY][k-1])%MOD;
//                    }
//                }
//            }
//        }
//        return dp[startRow][startColumn][maxMove];
//    }

//    int ans=0;
//    HashMap<String,Integer> map=new HashMap<>();
//    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
//        return dfs(m,n,maxMove,0,startRow,startColumn);
//    }
    // 记忆化递归
//    public int dfs(int m,int n,int maxMove,int move,int row,int col){
//        String cur=move+","+row+","+col;
//        if(!condition(m,n,row,col)) {
//            map.put(cur,1);
//            return 1;
//        }
//        if(move==maxMove) return 0;
//        if(map.containsKey(cur)) return map.get(cur);
//
//        int ret=0;
//        for (int[] direction : directions) {
//            int changeX = direction[0] + row;
//            int changeY = direction[1] + col;
//            ret= (int) ((ret+dfs(m,n,maxMove,move+1,changeX,changeY))%(1e9+7));
//        }
//        map.put(cur,ret);
//        return ret;
//    }
//    public void dfs(int m,int n,int maxMove,int move,int row,int col){
//        if(move==maxMove) return;
//        for (int[] direction : directions) {
//            int i = direction[0];
//            int j = direction[1];
//            int changeX=i+row;
//            int changeY=j+col;
//            if(!condition(m,n,changeX,changeY)){
//                ans= (int) ((ans+1)%(1e9+7));
//            }else dfs(m,n,maxMove,move+1,changeX,changeY);
//        }
//    }
}
