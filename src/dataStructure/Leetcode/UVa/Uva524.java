package dataStructure.Leetcode.UVa;

import java.util.Scanner;

/**
 * @author Yawen Cao
 * @data 2022/1/7 16:18
 */
public class Uva524 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int Case=1;
        isPrime();
        while(sc.hasNextInt()){
            int i = sc.nextInt();
            System.out.println("Case "+Case+":");
            solution(i);
            if(sc.hasNextInt()) System.out.println();
            Case++;
        }
    }
    static boolean[] isprime=new boolean[102];
    public static void solution(int n){
        int[] visited=new int[n+1];
        int[] arr=new int[n];
        arr[0]=1;
//        dfs(n,1,visited,arr);
        dfs1(n,1,visited,arr);
    }
    public static void dfs1(int n,int cur,int[] visited,int[] arr){
        if(cur==n){
            int i = arr[cur - 1] + arr[0];
            if(isprime[i]){
                for(int k=0;k<n-1;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println(arr[n-1]);
            }
            return;
        }
        for(int i=2;i<=n;i++){
            if(visited[i]==0){
                int sum = arr[cur - 1] + i;
                if(!isprime[sum]) continue;
                else{
                    visited[i]=1;
                    arr[cur]=i;
                    dfs1(n,cur+1,visited,arr);
                    visited[i]=0;
                }
            }
        }
    }
    public static void dfs(int n,int cur,int[] visited,int[] arr){
        if(cur==n){
            // check
            for(int i=0;i<n-1;i++){
                int sum=arr[i]+arr[i+1];
                if(!isprime[sum]) return;
            }
            int i = arr[n - 1] + arr[0];
            if(isprime[i]){
                for(int k=0;k<n-1;k++){
                    System.out.print(arr[k]+" ");
                }
                System.out.println(arr[n-1]);
            }
            return;
        }
        for(int i=2;i<=n;i++){
            if(visited[i]==0){
                visited[i]=1;
                arr[cur]=i;
                dfs(n,cur+1,visited,arr);
                visited[i]=0;
            }
        }
    }
    public static void isPrime(){
        isprime[2]=true;
        for(int i=3;i<=33;i++){
            int flag=-1;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0) {
                    flag=1;
                    isprime[i]=false;
                }
            }
            if(flag==-1) isprime[i]=true;
        }
    }
}
