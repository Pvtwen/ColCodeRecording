package dataStructure.Leetcode.dp1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/10 11:22
 */
public class Uva116 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr=new int[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            solution(arr);
        }
    }
    public static void solution(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        int[][] dp= new int[m][n];
        for (int[] ints : dp) {
            Arrays.fill(ints,Integer.MAX_VALUE);
        }
        // bound
        for(int i=0;i<m;i++){
            dp[i][n-1]=arr[i][n-1];
        }
        int[][] steps=new int[m][n];
        int res=Integer.MAX_VALUE;
        int first=0;
        // 外层列数
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<m;j++){
                int[] rows={j-1,j,j+1};
                if(j==0) rows[0]=m-1;
                if(j==m-1) rows[2]=0;
                // 对行号进行排序 以便选出字典序最小
                Arrays.sort(rows);
                for(int k=0;k<3;k++){
                    int i1 = arr[j][i] + dp[rows[k]][i+1];
                    if(i1<dp[j][i]){
                        dp[j][i]=i1;
                        // 更新steps路径
                        steps[j][i]=rows[k];
                    }
                }
                if(i==0 && dp[j][i]<res){
                    res=dp[j][i];
                    first=j;
                }
            }
        }
        // print step
        System.out.print(first+1);
        for(int i=1,j=steps[first][0];i<n;j=steps[j][i],i++){
            System.out.print(" "+(j+1));
        }
        System.out.print("\n"+dp[first][0]+"\n");
    }
}
