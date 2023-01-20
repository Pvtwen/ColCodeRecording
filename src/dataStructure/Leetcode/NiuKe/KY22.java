package dataStructure.Leetcode.NiuKe;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/3 9:41
 */
public class KY22 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int idx=0;
            int[] arr=new int[n];
            while(idx<n){
                arr[idx]=sc.nextInt();
                idx++;
            }
            solution(arr);
        }
    }
    public static void solution(int[] arr){
        int n = arr.length;
        // 下标以i结尾的最大序列和
        long[] f=new long[n];
        long res=Long.MIN_VALUE;
        // 因为规定了是非空的连续子序列T 所以不能与0比较
        f[0]=arr[0];
        res=Math.max(res,f[0]);
        for(int i=1;i<n;i++){
            f[i]=Math.max(f[i-1]+arr[i],arr[i]);
            res=Math.max(res,f[i]);
        }
        System.out.println(res);
    }
}
