package dataStructure.Leetcode.NumberTheory;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/24 17:24
 */
public class ACMQ1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0){
            int n = sc.nextInt();
            solution(n);
            T--;
        }
    }
    public static void solution(int n){
        boolean prime = isPrime(n + 1);
        if(prime) System.out.println(n+1);
        else System.out.println(-1);
    }
    public static boolean isPrime(int m){
        for(int i=2;i<=Math.sqrt(m);i++){
            if(m%i==0) return false;
        }
        return true;
    }
}
