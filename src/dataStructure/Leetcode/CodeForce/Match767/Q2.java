package dataStructure.Leetcode.CodeForce.Match767;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/22 23:13
 */
public class Q2 {
//    static int[] vis=new int[(int) (1e9+1)];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        while(n>0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            solution(l,r,k);
            n--;
        }
    }
    public static void solution(int l,int r,int k){
        if(r-l+1==1){
            if(l==1) System.out.println("NO");
            else System.out.println("YES");
            return;
        }
        // odd
        int num=(r-l+1)/2;
        if(l%2==1 && r%2==1){
            num++;
        }
        if(num<=k) System.out.println("YES");
        else System.out.println("NO");
    }
}
