package dataStructure.Leetcode.UVa;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/29 10:38
 */
public class Uva11346 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        while(n>0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int S = sc.nextInt();
            solution(a,b,S);
            n--;
        }
    }
    public static void solution(double a,double b,int S){
        double ans=0;
        if(S==0){
            String s = String.format("%.6f", 100d);
            System.out.println(s+"%");
            return;
        }
        if(a*b<=S){
            String s=String.format("%.6f",0d);
            System.out.println(s+"%");
            return;
        }
        double v =( a * b - S - S * (Math.log(a*b)-Math.log(S)))/(a*b);
//        System.out.println("fz:"+(( a * b - S - S * (Math.log(a*b)-Math.log(S)))));

        v*=100;
        String s1=String.format("%.6f",v);
        System.out.println(s1+"%");
    }
}
