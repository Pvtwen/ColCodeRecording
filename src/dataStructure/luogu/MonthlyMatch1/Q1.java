package dataStructure.luogu.MonthlyMatch1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/21 14:42
 */
public class Q1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0){
            long i = sc.nextLong();
            solution(i);
            T--;
        }
    }
    public static void solution(long n){
        // 2^k
        int i = Long.bitCount(n);
        if(i==1) {
            System.out.println(0);
            return;
        }
        //3*2^k
        if(n%3==0){
            n/=3;
            int i1 = Long.bitCount(n);
            if(i1==1){
                System.out.println(0);
            }else{
                System.out.println(1);
            }
        }else{
            System.out.println(1);
        }
    }
}
