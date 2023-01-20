package dataStructure.luogu;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/26 10:19
 */
public class P3383 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr=new int[q];
        int idx=0;
        getPrime(n);
        while(q>0){
            arr[idx++]=sc.nextInt();
            q--;
        }
        for(int i=0;i<arr.length;i++){
            System.out.println(primes[arr[i]-1]);
        }
    }
    static int[] primes=new int[6000010];
    static int[] st=new int[100000010];
    public static void getPrime(int n){
        int cnt=0;
        for(int i=2;i<=n;i++){
            if(st[i]==0) primes[cnt++]=i;
            for(int j=0;j<cnt;j++){
                if(i*primes[j]>n)  break;
                st[i*primes[j]]=1;
                if(i%primes[j]==0) break;
            }
        }
    }
}
