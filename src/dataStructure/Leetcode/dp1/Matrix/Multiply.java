package dataStructure.Leetcode.dp1.Matrix;

/**
 * @author Yawen Cao
 * @data 2022/2/23 9:40
 * 最有矩阵链乘
 */
public class Multiply {
    public static void solution(int n,int[] p){
        int[][] d=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            d[i][i]=0;
        }
        for(int len=2;len<=n;len++){
            for(int i=1;i+len-1<=n;i++){
                int j=i+len-1;
                for(int k=i;k<=j;k++){
                    d[i][j]=Math.min(d[i][j],d[i][k]+d[k+1][j]+p[i-1]*p[k]*p[j]);
                }
            }
        }
    }
}
