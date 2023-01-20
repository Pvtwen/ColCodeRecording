package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/29 11:31
 */
public class KY3 {
    static int N= (int) (1e7+10);
    static int[] primes=new int[N>>2];
    static int[] isPrime=new int[N];
    public static void getprimes() {
        int cnt = 0;
        for (int i = 2; i < N; i++) {
            if (isPrime[i] == 0) {
                primes[cnt++] = i;
            }
            for (int j = 0; j < cnt; j++) {
                if (primes[j] * i >= N) break;
                isPrime[i * primes[j]] = 1;
                if (i % primes[j] == 0) break;
            }
        }
    }
    public static void main(String[] args) {
        getprimes();
//        System.out.println("getprimes done");
//        for(int i=0;i<primes.length;i++){
//            if(primes[i]==0){
//                System.out.println("i:"+i+"ʱprimes[i]=0");
//                return;
//            }
//        }
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        while(n>0){
            solution(sc.nextInt());
            n--;
        }
    }
    public static void solution(int n){
        int ans=1;
        for(int i=0;i<primes.length;i++){
            if(primes[i]>n || primes[i]==0) break;
            int num=0;
            if(n%primes[i]==0){
                System.out.println(primes[i]);
            }
            while(n%primes[i]==0){
                n/=primes[i];
                num++;
            }
            ans*=(num+1);
        }
        System.out.println("remain n:"+n+"num:"+ans);
        if(n>1) ans*=2;
        System.out.println(ans);
    }
}
