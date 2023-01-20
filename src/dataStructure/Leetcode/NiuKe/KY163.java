package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/25 11:26
 */
public class KY163 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        isPrime(i);
    }
    public static void isPrime(int i){
        if(i==1){
            System.out.println("no");
            return;
        }
        for(int j=2;j<=Math.sqrt(i);j++){
            if(i%2==0){
                System.out.println("no");
                return;
            }
        }
        System.out.println("yes");
    }
}
