package dataStructure.Leetcode.dp1;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/10 10:38
 */
public class Uva1347 {
    // 对于dp[i][j]的定义，如果定义为第一个人走到i，第二个人走到j，还需要走多少。
    // 这个定义方案不可行，因为从状态来看，看不出i+1是否被j走过，换句话说，还需要
    // 记录i和j每个人的走的路径。
    // 定义为 1~max(i,j)都走过，还需要走多少，此时i和j为两人的位置，由于没有强制
    // 每个人必须走过每一个点，所以当一个人走到i+2时，就变成1~max(i,j)和i+2，禁止这样的操作
    // 所以可以强制其状态转移到dp[i+1][j],dp[i+1][i].此处也强行规定一维下标必须大于二维下标.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int idx=0;
            int[][] arr=new int[n][2];
            while(idx<n){
                arr[idx][0]=sc.nextInt();
                arr[idx][1]=sc.nextInt();
                idx++;
            }
            solution(arr);
        }
    }
    public static void solution(int[][] arr){
        int n = arr.length;
        double[][] dp= new double[n + 1][n + 1];
        // bound
        for(int i=1;i<=n-2;i++){
            dp[n-1][i]=compute(arr[n-2],arr[n-1])+compute(arr[i-1],arr[n-1]);
        }
        // i>j
        for(int i=n-2;i>=2;i--){
            for(int j=i-1;j>=1;j--){
                dp[i][j]=Math.min(dp[i+1][j]+compute(arr[i],arr[i-1]),dp[i+1][i]+compute(arr[j-1],arr[i]));
            }
        }
        String format = String.format("%.2f", dp[2][1] + compute(arr[0], arr[1]));
        System.out.println(format);
    }
    public static double compute(int[] a,int[] b){
        double ret = Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
        return ret;
    }
}
