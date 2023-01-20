package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/29 15:22
 */
public class KY3of1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        while(n>0){
            n--;
        }
    }
    public static void solution(int n){
        int num=0;
        int i;
        for(i=2;i*i<n;i++){
            if(n%i==0){
                num+=2;
            }
        }
        if(i*i==n) num++;
        System.out.println(num);
    }
}
