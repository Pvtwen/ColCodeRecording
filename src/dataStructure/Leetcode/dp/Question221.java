package dataStructure.Leetcode.dp;

/**
 * @author Yawen Cao
 * @data 2021/11/13 9:56
 */
public class Question221 {
    public static int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int res=Integer.MIN_VALUE;
        int[][] dp=new int[n][m];
        for(int i=0;i<m;i++){
            if(matrix[0][i]=='1') {
                dp[0][i]=1;
                res=1;
            }
        }
        for(int j=0;j<n;j++){
            if(matrix[j][0]=='1') {
                dp[j][0]=1;
                res=1;
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]=='0') continue;
                dp[i][j]=getMin(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1;
                res=Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
    public static int getMin(int a,int b,int c){
        int temp=Math.min(a,b);
        return Math.min(temp,c);
    }
}
