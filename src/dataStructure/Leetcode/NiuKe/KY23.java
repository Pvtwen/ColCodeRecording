package dataStructure.Leetcode.NiuKe;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/4 9:26
 */
public class KY23 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int L1 = sc.nextInt();
        int L2 = sc.nextInt();
        int L3 = sc.nextInt();
        int C1 = sc.nextInt();
        int C2 = sc.nextInt();
        int C3 = sc.nextInt();
        int st = sc.nextInt();
        int en = sc.nextInt();
        int[] L=new int[3];
        L[0]=L1;L[1]=L2;L[2]=L3;
        int[] C=new int[3];
        C[0]=C1;C[1]=C2;C[2]=C3;
        int N = sc.nextInt();
        int idx=1;
        int[] arr=new int[N+1];
        arr[0]=0;
        while(idx<N){
            arr[idx]=sc.nextInt();
            idx++;
        }
        solution(arr,L,C,st,en,N);
    }
    public static void solution(int[] arr,int[] L,int[] C,int st,int en,int N){
        // f[i]:到达i站台的最小花费
        int[] f=new int[N+1];
        Arrays.fill(f,Integer.MAX_VALUE);
        f[st]=0;
        for(int i=st+1;i<=en;i++){
            for(int j=i-1;j>=st;j--){
                int check = check(arr[i - 1] - arr[j - 1], L);
                if(check==-1) break;
                f[i]=Math.min(f[i],f[j]+C[check]);
            }
        }
        System.out.println(f[en]);
    }
    // 路程属于哪一段
    public static int check(int len,int[] L){
        if(len<=L[0]) return 0;
        else if(len>L[0] && len<=L[1]) return 1;
        else if(len>L[1] && len<=L[2]) return 2;
        else return -1;
    }
}
