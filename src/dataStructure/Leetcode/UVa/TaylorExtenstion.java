package dataStructure.Leetcode.UVa;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/6 16:51
 * lim E 1/k! =e
 */
public class TaylorExtenstion {
    public static void main(String[] args) {
        for(double n=1000d;n<1000000d;n+=10000){
            System.out.println("n="+n);
            double sum=0;
            float pre=1;
            for(int k=0;k<=n-1;k++){
                if(k==0) {
                    sum+=1;
                    continue;
                }
                // k!阶乘
//                System.out.println("k="+k);
                pre*=k;
                float base=pre;
                sum+=1/base;
            }
            System.out.println(sum);
            System.out.println();
        }
    }
}
