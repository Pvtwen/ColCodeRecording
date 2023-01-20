package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/7 14:48
 */
public class KY13 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int i = sc.nextInt();
            int idx=1;
            int min=sc.nextInt();
            int max=min;
            while(idx<i){
                int i1 = sc.nextInt();
                if(i1<min) min=i1;
                if(i1>max) max=i1;
                idx++;
            }
            System.out.print(max+" ");
            System.out.println(min);
        }
    }
}
