package dataStructure.Leetcode.dp1.Matrix;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/2/23 10:15
 */
public class Uva10003 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        while(n!=0){
            int seg = sc.nextInt();
            int[] segs=new int[seg];
            int idx=0;
            while(idx<seg){
                segs[idx++]=sc.nextInt();
            }
            solution(segs,n);

//            d=new int[seg+2][seg+2];
//            visited=new int[seg+2][seg+2];
//            a=new int[seg+2];
//            for(int i=1;i<=seg;i++){
//                a[i]=segs[i-1];
//            }
//            a[0]=0;a[seg+1]=n;
//            dfs(0,seg+1);
//            System.out.println("The minimum cutting is "+d[0][seg+1]+".");
            n=sc.nextInt();
        }
    }
    static int[][] d;
    // 由于段长依赖于段短 并且可以发现，解答树存在大量重复计算(可以画一个有很多个切割点的图 随便找一段 便可以发现)
    static int[][] visited;
    static int[] a;
    public static int dfs(int i,int j){
        if(i>=j-1) return 0;
        if(visited[i][j]==1) return d[i][j];
        visited[i][j]=1;
        d[i][j]=-1;
        for(int k=i+1;k<=j-1;k++){
            int v=dfs(i,k)+dfs(k,j)+a[j]-a[i];
            if(d[i][j]<0 || v<d[i][j]) d[i][j]=v;
        }
        return d[i][j];
    }
    // 范围为1~n
    static int MAX=50+5;
    public static void solution(int[] segs,int L){
        int n = segs.length;
        int[] a=new int[MAX];
        for(int i=1;i<=n;i++){
            a[i]=segs[i-1];
        }
        a[0]=0;a[n+1]=L;
        int[][] dp=new int[MAX][MAX];
        for(int len=3;len<=n+2;len++){
            for(int i=0;i+len-1<=n+2;i++){
                int j=i+len-1;
                dp[i][j]=-1;
                for(int k=i+1;k<=j-1;k++){
//                    dp[i][j]=Math.min(dp[i][j],dp[i][k]+dp[k][j])+a[j]-a[i];
                    int v=dp[i][k]+dp[k][j]+a[j]-a[i];
                    if(dp[i][j]<0 || v<dp[i][j]) dp[i][j]=v;
                }
            }
        }
        System.out.println("The minimum cutting is "+dp[0][n+1]+".");
    }
}
