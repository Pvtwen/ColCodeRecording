package dataStructure.Leetcode.NumberTheory;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/20 16:08
 * 无平方因子的树
 */
public class example2 {
    // 找出<=n的所有素数
    public static void solution() {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int[] vis=new int[n+1];
//        for(int i=2;i<=n;i++){
//            for(int j=i*2;j<=n;j+=i) vis[j]=1;
//        }

        for(int i=1;i<=n;i++){
            if(vis[i]!=1){
                for(int  j=i*i;j<=n;j++){
                    vis[j]=1;
                }
            }
        }
    }
    // 找出[n,m]区间内的所有素数
    // 根据小于等于m^1/2的素数p 筛选
    public static void solution1(int n,int  m){
        int[] vis=new int[m+1];
        for(int i=2;i<=Math.sqrt(m);i++){
            int p=i*i;
            if(vis[p]!=1){
                for(int j=p*p;j<=m;j+=p){
                    vis[j]=1;
                }
            }
        }
        int cnt=0;
        for(int  i=n;i<=m;i++){
            if(vis[i]==1) cnt++;
        }
    }
}
