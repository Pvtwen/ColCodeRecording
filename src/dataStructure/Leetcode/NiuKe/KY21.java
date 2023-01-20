package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/7 14:06
 */
public class KY21 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a0 = sc.nextInt();
        int a1 = sc.nextInt();
        int p = sc.nextInt();
        int q = sc.nextInt();
        int k = sc.nextInt();
        long q1=a0,p1=a1;
        for(int i=2;i<=k;i++){
            long n=q1*q+p1*p;
            q1=p1;p1=n;
        }
        System.out.println(p1%10000);
    }
}
