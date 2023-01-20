package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/7 14:54
 */
public class KY35 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i = sc.nextInt();
        while(i!=0){
            int[] arr=new int[i];
            int idx=0;
            while(idx<i){
                arr[idx]=sc.nextInt();
                idx++;
            }
            solution(arr);
            i=sc.nextInt();
        }
    }
    public static  void solution(int[] arr){
        int n = arr.length;
        int ret=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int gcd = gcd(arr[i], arr[j]);
                if(gcd==1) ret++;
            }
        }
        System.out.println(ret);
    }
    public static int gcd(int x,int y){
        int rem=-1;
        while(rem!=0){
            rem = x % y;
            x=y;
            y=rem;
        }
        return x;
    }
}
