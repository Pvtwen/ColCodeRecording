package dataStructure.Leetcode.NiuKe;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/3/3 9:56
 */
public class KY14 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V = sc.nextInt();
        int n = sc.nextInt();
        int[] arr=new int[n];
        int idx=0;
        while(idx<n){
            arr[idx]=sc.nextInt();
            idx++;
        }
        solution1(arr,V);
    }
    static int N= (int) 1e8;
    public static void solution(int[] arr,int V){
        int n = arr.length;
        int[][] f=new int[n][V+1];
        // 用于打印方案
        int[][] aux=new int[n][V+1];
        for (int[] ints : f) {
            Arrays.fill(ints,N);
        }
        for(int i=0;i<=V;i++){
            if(arr[0]==i) f[0][i]=1;
        }
        for(int i=0;i<n;i++){
            f[i][0]=0;
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=V;j++){
                if(j<arr[i]) f[i][j]=f[i-1][j];
                else {
                    f[i][j]=Math.min(f[i-1][j],f[i-1][j-arr[i]]+1);
                    if(f[i][j]==f[i-1][j-arr[i]]+1){
                        aux[i][j]=1;
                    }
                }
              // 下面是完全背包的状态转移方程
//                else f[i][j]=Math.min(f[i-1][j],f[i][j-arr[i]]+1);
            }
        }
        int ret = f[n - 1][V] >= 1e8 ? 0 : f[n - 1][V];
        System.out.println(ret);
        // print solution
        int v=V;
        for(int i=n-1;i>=0 && v>=0;i--){
            if(aux[i][v]==1){
                System.out.println(i);
                v-=arr[i];
            }
        }
    }
    // 滚动数组
    public static void solution1(int[] arr,int V){
        int n = arr.length;
        int[] f=new int[V+1];
        Arrays.fill(f,N);
        for(int i=0;i<=V;i++){
            if(arr[0]==i) f[i]=1;
        }
        f[0]=0;
        for(int i=1;i<n;i++){
            for(int j=V;j>=arr[i];j--){
                f[j]=Math.min(f[j],f[j-arr[i]]+1);
            }
        }
        int i = f[V] >= N ? 0 : f[V];
        System.out.println(i);
    }
}