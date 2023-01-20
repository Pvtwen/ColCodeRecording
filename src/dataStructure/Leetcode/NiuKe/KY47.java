package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/7 14:33
 */
public class KY47 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int layerA=0,layerB=0;
            int tmpA=a,tmpB=b;
            while(tmpA!=1){
                layerA++;
                tmpA/=2;
            }
            while(tmpB!=1){
                layerB++;
                tmpB/=2;
            }
            while(layerA!=layerB){
                if(layerA>layerB){
                    a/=2;
                    layerA--;
                }
                if(layerB>layerA){
                    b/=2;
                    layerB--;
                }
            }
            while(a!=b){
                a/=2;
                b/=2;
            }
            System.out.println(a);
        }
    }
}
