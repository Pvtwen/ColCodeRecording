package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/5 9:42
 */
public class KY61 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //m apple n plate
        while(sc.hasNext()){
            int m = sc.nextInt();
            int n = sc.nextInt();
            solution1(m,n);
        }
    }
    static int[][] record;
    public static void solution1(int m,int n){
        record=new int[m+1][n+1];
        int dfs = dfs(m, n);
        System.out.println(dfs);
    }
    //m n 从m和n开始，要放的苹果和盘子的数量
    public static int dfs(int m,int n){
        if(n==1) return 1;
        if(m==0 || m==1) return 1;
        if(record[m][n]!=0) return record[m][n];
        // 转移
        int ans=0;
        if(n>m){
            ans+=dfs(m,m);
        }else{
            ans+=dfs(m-n,n);
            ans+=dfs(m,n-1);
        }
        record[m][n]=ans;
        return ans;
    }
    public static void solution(int m,int n){
        int[][] f=new int[m+1][n+1];
        for(int i=0;i<=n;i++){
            f[0][i]=1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                // 如果盘子数大于苹果数 至少有n-m个空盘子必不可能放苹果
                if(j>i) f[i][j]=f[i][i];
                // 如果苹果数大于盘子数，那么总的方案数=有空盘子的方案+没有空盘子的方案。
                // 首先说没有空盘子的方案，先从每个盘子至少有一个苹果转移而来,即f[i-j][j]
                // 再说至少有一个空盘子的方案 直接从f[i][j-1]转移而来.因为f[i][j-1]这个状态已经包含了至少2,3,...j-1个空盘子
                else f[i][j]=f[i-j][j]+f[i][j-1];
            }
        }
        System.out.println(f[m][n]);
    }
}
