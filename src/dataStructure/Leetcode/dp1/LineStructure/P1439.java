package dataStructure.Leetcode.dp1.LineStructure;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/21 20:02
 * 最长公共上升子序列问题
 */
public class P1439 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1=new int[n+1];
        int[] arr2=new int[n+1];
        int idx=0;
        while(idx<n){
            arr1[idx++]=sc.nextInt();
        }
        idx=0;
        while(idx<n){
            arr2[idx++]=sc.nextInt();
        }
        solution(n,arr1,arr2);
        System.out.println(dp[n][n]);
    }
    static int[][] dp;
    public static void solution(int n,int[] arr1,int[] arr2){
        dp=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int i1 = arr1[i-1];
                int i2 = arr2[j-1];
                if(i1==i2) dp[i][j]=dp[i-1][j-1]+1;
                else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
    }
}