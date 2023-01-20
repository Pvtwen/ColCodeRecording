package dataStructure.Leetcode.dp1;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/8 9:45
 */
public class Uva1025 {
    static int tot=1;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n==0) break;
            int T=sc.nextInt();
            int idx=1;
            int[] t=new int[n];
            while(idx<=n-1){
                t[idx++]=sc.nextInt();
            }
            int M1=sc.nextInt();
            int[] a=new int[M1];
            idx=0;
            while(idx<M1){
                a[idx++]=sc.nextInt();
            }
            int M2=sc.nextInt();
            int[] b=new int[M2];
            idx=0;
            while(idx<M2){
                b[idx++]=sc.nextInt();
            }
            solution1(n,T,t,M1,a,M2,b);
            tot++;
        }
    }
    public static void solution1(int n,int T,int[] t,int M1,int[] a,int M2,int[] b){
        int[][][] hasTrain=new int[T+1][n+1][2];
        trainTime(hasTrain,a,b,t,T);

        // 到达 T时刻 n站台至少需要等待多少时间
        int[][] dp=new int[T+1][n+1];
        for(int i=2;i<=n;i++) dp[0][i]= (int) 1e8;
        dp[0][1]=0;
        for(int k=1;k<=T;k++){
            for(int m=n;m>=1;m--){
                dp[k][m]=dp[k-1][m]+1;  // 等一单位时间
                // 向右
                if(m>1 && hasTrain[k][m][0]==1 && k-t[m-1]>=0){
                    dp[k][m]=Math.min(dp[k][m],dp[k-t[m-1]][m-1]);
                }
                if(m<n && hasTrain[k][m][1]==1 && k-t[m]>=0){
                    dp[k][m]=Math.min(dp[k][m],dp[k-t[m]][m+1]);
                }
            }
        }
        if(dp[T][n]>=1e8) System.out.println("Case Number "+tot+": impossible");
        else System.out.println("Case Number "+tot+": "+dp[T][n]);
    }
    public static void solution(int n,int T,int[] t,int M1,int[]a ,int M2,int[] b){
        // 求某个时刻某个站台是否有列车
        int[][][] hasTrain=new int[T+1][n+1][2];
        trainTime(hasTrain,a,b,t,T);

        // 在T时刻 n站台 到达终点最少需要的时间
        int[][] dp=new int[T+1][n+1];
        for(int i=1;i<=n-1;i++){
            dp[T][i]= (int) 1e8;
        }
        dp[T][n]=0;
        for(int k=T-1;k>=0;k--){
            for(int m=1;m<=n;m++){
                // 三次填表 三种决策
                dp[k][m]=dp[k+1][m]+1;
                if(m<n && hasTrain[k][m][0]==1 && k+t[m]<=T){
                    // 只有等待的时间才算进dp 在动车上不算 所以不用dp[k+t[m]][m+1]+t[m];
                    dp[k][m]=Math.min(dp[k][m],dp[k+t[m]][m+1]);
                }
                if(m>1 && hasTrain[k][m][1]==1 && k+t[m-1]<=T){
                    dp[k][m]=Math.min(dp[k][m],dp[k+t[m-1]][m-1]);
                }
            }
        }
        if(dp[0][1]>=1e8) System.out.println("Case Number "+tot+": impossible");
        else System.out.println("Case Number "+tot+": "+dp[0][1]);
    }
    public static void trainTime(int[][][] hasTrain,int[] a,int[] b,int[] t,int T){
        for (int a1 : a) {
            int idx=1;
            if(a1>T) break;
            hasTrain[a1][idx++][0]=1;
            int base=a1;
            for (int i=1;i<t.length;i++) {
                base+=t[i];
                if(base>T) break;
                hasTrain[base][idx++][0]=1;
            }
        }
        for (int b1 : b) {
            int idx=t.length;
            if(b1>T) break;
            hasTrain[b1][idx--][1]=1;
            int base=b1;
            for(int i=t.length-1;i>=1;i--){
                base+=t[i];
                if(base>T) break;
                hasTrain[base][idx--][1]=1;
            }
        }
    }
}
