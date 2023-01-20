package dataStructure.Leetcode.NumberTheory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/24 18:16
 * 线性筛 (埃氏 euler）
 */
public class isPrime {
    // 埃氏筛
//    static int[] vis=new int[(int) (1e7+1)];
//    static HashSet<Integer> set=new HashSet<>();
//    public static void main(String[] args) {
//        for(int i=2;i<=Math.sqrt(1e7);i++){
//            if(!set.contains(i)){
//                for(int j=i*i;j<=1e7;j+=i){
//                    set.add(j);
//                }
//            }
//        }
//        Scanner sc=new Scanner(System.in);
//        int i = sc.nextInt();
//        while(i>0){
//            int i1 = sc.nextInt();
//            if(set.contains(i1)) System.out.println(0);
//            else System.out.println(1);
//            i--;
//        }
//    }

    // euler筛
    // 1~n之间的素数
    public void Euler(int n){
        List<Integer> primes=new ArrayList<>();
        int[] isPrimes=new int[n];
        for(int i=2;i<=n;i++){
            if(isPrimes[i]==0){
                primes.add(i);
            }
            for (Integer prime : primes) {
                if(prime*i>n) break;
                isPrimes[i*prime]=1;
                // 保证只筛选一次
                if(i%prime==0) break;
            }
        }
    }

    static int N= (int) (1e7+1);
    static int[] primes=new int[N>>1];
    static HashSet<Integer> set=new HashSet<>();
    public static void main(String[] args) {
            Euler1();
            Scanner sc=new Scanner(System.in);
            int i = sc.nextInt();
            if(!set.contains(i)) System.out.println(1);
            else System.out.println(0);
    }
    // 只选出合数
    public static void Euler1(){
        // 最多n/2个素数 推导
        // primes[i]=j. 意味着第i个素数是j
//        int[] primes=new int[n/2];
        // 存放合数
//        HashSet<Integer> set=new HashSet<>();
        int cnt=0;
        for(int i=2;i<=N;i++){
            if(!set.contains(i)) primes[cnt++]=i;
            for(int j=0;j<cnt;j++){
                if(primes[j]*i>N) break;;
                set.add(primes[j]*i);
                if(i%primes[j]==0) break;
            }
        }
    }
}
