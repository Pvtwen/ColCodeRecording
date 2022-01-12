package dataStructure.Leetcode.UVa;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/6 16:14
 */
public class Uva10976 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int i = sc.nextInt();
            solution(i);
        }
    }
    //1/2 = 1/6 + 1/3
    public static void solution(int val){
        int ret=0;
        for(int y=val+1;y<=2*val;y++){
            int x=val*y/(y-val);
            // check
            if(val*(x+y)==x*y) ret++;
        }
        System.out.println(ret);
        for(int y=val+1;y<=2*val;y++){
            int x=val*y/(y-val);
            // check
            if(val*(x+y)==x*y) System.out.println("1/"+val+" = 1/"+x+" + 1/"+y);
        }
    }
}
