package dataStructure.Leetcode.NumberTheory;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/26 9:50
 */
public class P1226 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int p = sc.nextInt();
        solution(a,b,p);
    }
    public static void solution(int a,int b,int p){
        long fz = fz(a, b, p);
        System.out.println(a+"^"+b+" mod "+p+"="+fz);
    }
    public static long fz(int a,int b,int p){
        if(b==0) return 1;
        long ans=fz(a,b/2,p);
        long x=ans*ans%p;
        if(b%2==1) x=x*a%p;
        return (x%p);
    }
}
