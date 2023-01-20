package dataStructure.Leetcode.dp1.Matrix;

/**
 * @author Yawen Cao
 * @data 2022/2/23 9:48
 */
public class Triangulation {
    public static void solution(int[][][] w,int n){
        int[][] d=new int[n+1][n+1];
        for(int i=1;i+1<=n;i++){
            d[i][i+1]=0;
        }
        for(int len=2;len<=n;len++){
            for(int i=1;i+len-1<=n;i++){
                int j=i+len-1;
                for(int k=i;k<=j;k++){
                    d[i][j]=Math.min(d[i][j],d[i][k]+d[k][j]+w[i][j][k]);
                }
            }
        }
        System.out.println(d[0][n-1]);
    }
}
