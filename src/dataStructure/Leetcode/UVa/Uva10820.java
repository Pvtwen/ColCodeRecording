package dataStructure.Leetcode.UVa;

import dataStructure.Test.S;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/26 15:25
 */
public class Uva10820 {
    public static void main(String[] args) {
        getEuler();
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        while(i!=0){
            if(i==1) System.out.println(1);
            else{
                long sum=0;
                for(int j=2;j<=i;j++){
                    sum+=phi[j];
                }
                long ans=2*sum;
                System.out.println(ans+1);
            }
            i=sc.nextInt();
        }
    }
    static long[] phi= new long[50001];
    public static void getEuler(){
        phi[1]=1;
        for(int i=2;i<=50000;i++){
            if(phi[i]==0){
                // 埃氏筛种这里j=i*i，因为只需要筛选出合数。这里函数要求出每一个i的欧拉值，所以j=i.否则如果i=2，算不出phi[2
                for(int j=i;j<=50000;j+=i){
                    if(phi[j]==0) phi[j]=j;
                    phi[j]=phi[j]*(i-1)/i;
                }
            }
        }
    }
}
