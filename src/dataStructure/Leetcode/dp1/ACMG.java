package dataStructure.Leetcode.dp1;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/7 11:25
 */
public class ACMG {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int i=0;
        int[] arr=new int[n];
        while(i<n){
            arr[i]=sc.nextInt();
            i++;
        }
        solution(n,arr);
    }
    // 刷表  更新dp[i]影响到的状态
    public static void solution(int n,int[] arr){
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=i+1;
        }
        for(int i=0;i<n;i++){
            int dest = arr[i]-1;
            // 刷表 更新dp[i]影响的状态
            dp[dest]=Math.min(dp[dest],dp[i]+1);
            if(i>=1){
                // 填表 dp[i]由依赖的状态决定
                dp[i]=Math.min(dp[i],dp[i-1]+1);
            }
            if(i+1<n){
                // 刷表 更新捷径影响的状态
                dp[i+1]=Math.min(dp[i+1],dp[i]+1);
            }
        }
        for(int i=0;i<n-1;i++){
            System.out.print(dp[i]+" ");
        }
        System.out.print(dp[n-1]);
    }
}
